package com.billyoyo.cardcrawl.py.impl;

import com.billyoyo.cardcrawl.py.interfaces.PyRelic;
import com.billyoyo.cardcrawl.py.localization.strings.RelicStringsImpl;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by william on 24/01/2018.
 */
public class PyLocalizedStringsImpl extends LocalizedStrings {

    private Map<String, RelicStrings> overrideRelics = new HashMap<>();

    public PyLocalizedStringsImpl() {

    }

    public void registerRelic(String relicName, RelicStrings relicStrings) {
        overrideRelics.put(relicName, relicStrings);
    }

    public void registerRelic(PyRelic relic) {
        registerRelic(relic.getId(), new RelicStringsImpl(
                relic.getName(), relic.getFlavorText(), new String[] {
                    "", "", relic.getUsedUpText()
                }
        ));
    }

    @Override
    public RelicStrings getRelicStrings(String relicName) {
        return overrideRelics.get(relicName);
    }
}
