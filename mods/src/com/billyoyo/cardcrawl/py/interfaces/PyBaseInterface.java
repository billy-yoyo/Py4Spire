package com.billyoyo.cardcrawl.py.interfaces;

import com.billyoyo.cardcrawl.py.util.mods.PyMod;

/**
 * Created by william on 25/01/2018.
 */
public class PyBaseInterface {

    public PyMod pyModParent = null;

    // called before any of the other methods
    public void setup(String lang) {}

    // called after the relic has been added to the game's relic library
    public void registered() {}
}
