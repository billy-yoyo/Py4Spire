package com.billyoyo.cardcrawl.py.util.mods;

/**
 * Created by william on 24/01/2018.
 */
public class PyMod {
    public String name;
    public String folder;
    public int priority;
    public PyModComponent[] components;

    public int getPriority() {
        return priority;
    }
}
