package com.billyoyo.cardcrawl.py.util.mods;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.billyoyo.cardcrawl.py.impl.PyCardImpl;
import com.billyoyo.cardcrawl.py.impl.PyRelicImpl;
import com.billyoyo.cardcrawl.py.interfaces.PyCard;
import com.billyoyo.cardcrawl.py.interfaces.PyRelic;
import com.billyoyo.cardcrawl.py.util.PyFiles;
import com.billyoyo.cardcrawl.py.util.PyObjectFactory;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import org.python.core.PySystemState;

import java.io.File;

/**
 * Created by william on 24/01/2018.
 */
public class PyModLoader {

    public static PyMod loadMod(File file) {
        FileHandle fileHandle = PyFiles.getFileHandle(file.getName());
        Json json = new Json();
        return json.fromJson(PyMod.class, fileHandle);
    }

    private static String createComponentPackage(PyMod mod, PyModComponent component) {
        String file = component.file;
        if (file.endsWith(".py")) {
            file = file.substring(0, file.length() - 3);
        }

        return PyFiles.MOD_PACKAGE + "." + mod.folder + "." + file;
        //return file;
    }

    public static void startMod(PyMod mod) {
        PySystemState.initialize();

        for (PyModComponent component : mod.components) {
            try {
                String pkg = createComponentPackage(mod, component);
                System.out.println("starting component with type: " + component.type + ", name: " + component.name);

                switch (component.type.toLowerCase()) {
                    case "relic":
                        createRelicComponent(mod, pkg, component.name);
                        break;
                    case "card":
                        createCardComponent(mod, pkg, component.name);
                        break;
                }
            } catch (Exception e) {
                System.out.println("failed to start component " + component.name + " of mod " + mod.name);
                e.printStackTrace();
            }
        }
    }

    private static void createRelicComponent(PyMod mod, String pkg, String name) {
        PyObjectFactory factory = new PyObjectFactory(PyRelic.class, pkg, name);
        PyRelic relic = factory.create();
        relic.pyModParent = mod;
        PyRelicImpl relicImpl = PyRelicImpl.createRelic(relic);

        String relicColour = relicImpl.getRelicColour().toLowerCase();

        switch (relicColour) {
            case "green":
                RelicLibrary.addGreen(relicImpl);
                break;
            case "red":
                RelicLibrary.addRed(relicImpl);
                break;
            case "blue":
                RelicLibrary.addBlue(relicImpl);
                break;
            default:
                RelicLibrary.add(relicImpl);
                break;
        }

        relic.registered();
    }

    private static void createCardComponent(PyMod mod, String pkg, String name) {
        PyObjectFactory factory = new PyObjectFactory(PyCard.class, pkg, name);
        PyCard card = factory.create();
        card.pyModParent = mod;
        PyCardImpl cardImpl = PyCardImpl.createCard(card);

        CardLibrary.add(cardImpl);

        card.registered();
    }
}
