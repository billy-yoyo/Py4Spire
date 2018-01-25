package com.billyoyo.cardcrawl.py.interfaces;

import com.billyoyo.cardcrawl.py.impl.PyCardImpl;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

/**
 * Created by william on 25/01/2018.
 */
public abstract class PyCard extends PyBaseInterface {

    public PyCardImpl impl = null;

    public abstract PyCard copy();

    public abstract String getId();
    public abstract String getName();
    public abstract String getImage();
    public abstract int getCost();
    public abstract String getDescription();
    public abstract String getCardType();
    public abstract String getColor();
    public abstract String getTarget();
    public abstract String getRarity();

    public abstract void upgrade();
    public abstract void use(AbstractPlayer player, AbstractMonster monster);

    public boolean canPlay(AbstractCard card) {
        return true;
    }
    public void tookDamage() {}
    public void didDiscard() {}
    public void triggerWhenDrawn() {}
    public void triggerOnEndOfPlayerTurn() {}
    public void triggerOnEndOfTurnForPlayingCard() {}
    public void triggerOnOtherCardPlayed(AbstractCard c) {}
    public void triggerOnGainEnergy(int e, boolean dueToCard) {}
    public void triggerOnManualDiscard() {}
    public void onPlayCard(AbstractCard c, AbstractMonster m) {}
    public void atTurnStart() {}
    public void triggerOnExhaust() {}
    public void onMoveToDiscard() {}
}
