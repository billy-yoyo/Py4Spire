package com.billyoyo.cardcrawl.py.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 24/01/2018.
 */
public class PyFiles {
    public static final String MOD_PACKAGE = "pymods";

    public static String getPath(String modPath) {
        return Paths.get(MOD_PACKAGE, modPath).normalize().toString();
    }

    public static String[] splitByExtension(String filePath) {
        return filePath.split("\\.(?=[^\\.]+$)");
    }

    public static String getExtension(String filePath) {
        return filePath.contains(".") ? splitByExtension(filePath)[1] : "";
    }

    public static FileHandle getFileHandle(String modPath) {
        System.out.println("getting file handle, base path: " + modPath);
        modPath = getPath(modPath);
        System.out.println("converted path:" + modPath);
        return Gdx.files.local(modPath);
    }

    public static Texture getTexture(String modPath) {
        return new Texture(getFileHandle(modPath));
    }

    public static List<File> getAllModFiles() {
        List<File> modFiles = new ArrayList<>();

        File folder = new File(MOD_PACKAGE);
        System.out.println("folder exists: " + folder.exists() + ", is folder: " + folder.isDirectory() + ", absolute path: " + folder.getAbsolutePath());

        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            System.out.println("found " + listOfFiles.length + " files in " + folder.getPath());
            for (File file : listOfFiles) {
                if (getExtension(file.getPath()).equals("json")) {
                    modFiles.add(file);
                }
            }
        } else {
            System.out.println("no files found, path " + folder.getPath() + " invalid?");
        }

        return modFiles;
    }

}
