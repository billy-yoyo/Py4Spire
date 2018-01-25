package com.billyoyo.cardcrawl.py.api;

import com.megacrit.cardcrawl.cards.AbstractCard;

/**
 * Created by william on 25/01/2018.
 */
public class CardHelper {
    public static final String TYPE_ATTACK = "ATTACK";
    public static final String TYPE_SKILL = "SKILL";
    public static final String TYPE_POWER = "POWER";
    public static final String TYPE_SATUS = "STATUS";
    public static final String TYPE_CURSE = "CURSE";

    public static AbstractCard.CardType getCardType(String cardTypeString) {
        return AbstractCard.CardType.valueOf(cardTypeString.toUpperCase());
    }

    public static final String COLOUR_RED = "RED";
    public static final String COLOUR_GREEN = "GREEN";
    public static final String COLOUR_BLUE = "BLUE";
    public static final String COLOUR_COLORLESS = "COLORLESS";
    public static final String COLOUR_CURSE = "CURSE";

    public static AbstractCard.CardColor getCardColor(String cardColorString) {
        return AbstractCard.CardColor.valueOf(cardColorString.toUpperCase());
    }

    public static final String RARITY_BASIC = "BASIC";
    public static final String RARITY_SPECIAL = "SPECIAL";
    public static final String RARITY_COMMON = "COMMON";
    public static final String RARITY_UNCOMMON = "UNCOMMON";
    public static final String RARITY_RARE = "RARE";
    public static final String RARITY_CURSE = "CURSE";

    public static AbstractCard.CardRarity getCardRarity(String cardRarityString) {
        return AbstractCard.CardRarity.valueOf(cardRarityString.toUpperCase());
    }

    public static final String TARGET_ENEMY = "ENEMY";
    public static final String TARGET_ALL_ENEMY = "ALL_ENEMY";
    public static final String TARGET_SELF = "SELF";
    public static final String TARGET_NONE = "NONE";
    public static final String TARGET_SELF_AND_ENEMY = "SELF_AND_ENEMY";
    public static final String TARGET_ALL = "ALL";

    public static AbstractCard.CardTarget getCardTarget(String cardTargetString) {
        return AbstractCard.CardTarget.valueOf(cardTargetString.toUpperCase());
    }
}
