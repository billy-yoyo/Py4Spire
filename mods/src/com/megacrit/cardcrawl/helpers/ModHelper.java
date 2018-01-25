//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.megacrit.cardcrawl.helpers;

import com.billyoyo.cardcrawl.py.PyLoader;
import com.megacrit.cardcrawl.daily.mods.AbstractDailyMod;
import com.megacrit.cardcrawl.daily.mods.CursedRun;
import com.megacrit.cardcrawl.daily.mods.DoubleElites;
import com.megacrit.cardcrawl.daily.mods.LethalEnemies;
import com.megacrit.cardcrawl.daily.mods.NightTerrors;
import com.megacrit.cardcrawl.daily.mods.RestlessJourney;
import com.megacrit.cardcrawl.daily.mods.Vintage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Map.Entry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModHelper {
    private static final Logger logger = LogManager.getLogger(ModHelper.class.getName());
    private static HashMap<String, AbstractDailyMod> mods = new HashMap();

    public ModHelper() {
    }

    public static void initialize() {
        add(new CursedRun());
        add(new DoubleElites());
        add(new LethalEnemies());
        add(new RestlessJourney());
        add(new Vintage());
        add(new NightTerrors());

        PyLoader.entryPoint();
    }

    public static void add(AbstractDailyMod mod) {
        mods.put(mod.name, mod);
    }

    public static AbstractDailyMod getMod(String key) {
        return (AbstractDailyMod)mods.get(key);
    }

    public static HashMap<String, Boolean> getMods(int numOfMods, Random random) {
        HashMap retVal = new HashMap();
        ArrayList tmp = new ArrayList();
        Iterator i = mods.entrySet().iterator();

        while(i.hasNext()) {
            Entry m = (Entry)i.next();
            tmp.add(m.getValue());
            retVal.put(m.getKey(), Boolean.valueOf(false));
        }

        Collections.shuffle(tmp, random);
        logger.info(tmp);

        for(int var6 = 0; var6 < numOfMods; ++var6) {
            retVal.put(((AbstractDailyMod)tmp.get(var6)).name, Boolean.valueOf(true));
        }

        return retVal;
    }

    public static HashMap<String, Boolean> noMods() {
        HashMap retVal = new HashMap();
        Iterator var1 = mods.entrySet().iterator();

        while(var1.hasNext()) {
            Entry m = (Entry)var1.next();
            retVal.put(m.getKey(), Boolean.valueOf(false));
        }

        return retVal;
    }
}
