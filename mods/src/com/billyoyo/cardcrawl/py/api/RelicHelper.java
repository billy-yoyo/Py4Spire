package com.billyoyo.cardcrawl.py.api;

import com.megacrit.cardcrawl.relics.AbstractRelic;

/**
 * Created by william on 24/01/2018.
 */
public class RelicHelper {
    public static final String TIER_DEPRACATED = "DEPRACTED";
    public static final String TIER_STARTER = "STARTER";
    public static final String TIER_COMMON = "COMMON";
    public static final String TIER_UNCOMMON = "UNCOMMON";
    public static final String TIER_RARE = "RARE";
    public static final String TIER_SPECIAL = "SPECIAL";
    public static final String TIER_BOSS = "BOSS";
    public static final String TIER_SHOP = "SHOP";

    public static AbstractRelic.RelicTier getRelicTier(String relicTier)
    {
        return AbstractRelic.RelicTier.valueOf(relicTier.toUpperCase());
    }

    public static final String SOUND_CLINNK = "CLINK";
    public static final String SOUND_FLAT = "FLAT";
    public static final String SOUND_HEADER = "HEAVY";
    public static final String SOUND_MAGICAL = "MAGICAL";
    public static final String SOUND_SOLID = "SOLID";

    public static AbstractRelic.LandingSound getRelicLandingSound(String landingSound)
    {
        return AbstractRelic.LandingSound.valueOf(landingSound.toUpperCase());
    }

    public static final String COLOR_GREEN = "GREEN";
    public static final String COLOR_RED = "RED";
    public static final String COLOR_BLUE = "BLUE";
    public static final String COLOR_NONE = "NONE";
}
