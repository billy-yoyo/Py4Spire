package com.billyoyo.cardcrawl.py;


import com.billyoyo.cardcrawl.py.util.PyFiles;
import com.billyoyo.cardcrawl.py.util.mods.PyMod;
import com.billyoyo.cardcrawl.py.util.mods.PyModLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by william on 24/01/2018.
 */
public class PyLoader {

    public static List<PyMod> loadMods() {
        List<PyMod> mods = new ArrayList<>();

        List<File> modFiles = PyFiles.getAllModFiles();
        for (File file : modFiles) {
            try {
                mods.add(PyModLoader.loadMod(file));
            } catch (Exception e) {
                System.out.println("failed to load mod file "+ file.getName());
                e.printStackTrace();
                // allow mod to silently fail
            }
        }

        return mods;
    }

    public static void orderMods(List<PyMod> mods) {
        mods.sort(Comparator.comparing(PyMod::getPriority));
    }

    public static void entryPoint() {
        List<PyMod> mods = loadMods();
        orderMods(mods);

        for (PyMod mod : mods) {
            try {
                System.out.println("loading mod " + mod.name);
                PyModLoader.startMod(mod);
            } catch (Exception e) {
                System.out.println("failed to start mod " + mod.name);
                e.printStackTrace();
                // allow mod to silently fail
            }
        }
    }
}
