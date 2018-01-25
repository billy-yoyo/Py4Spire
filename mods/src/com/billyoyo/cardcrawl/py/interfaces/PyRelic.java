package com.billyoyo.cardcrawl.py.interfaces;

import com.billyoyo.cardcrawl.py.impl.PyRelicImpl;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

/**
 * Created by william on 24/01/2018.
 */
public abstract class PyRelic extends PyBaseInterface {

    public PyRelicImpl impl = null;

    public abstract PyRelic copy();

    public abstract String getId();
    public abstract String getImage();
    public abstract String getRelicTier();
    public abstract String getLandingSound();
    public abstract String getDescription();
    public abstract String getName();
    public abstract String getFlavorText();
    public abstract String getUsedUpText();
    public abstract String getRelicColor();

    public void onPlayCard(AbstractCard c, AbstractMonster m) {}
    public void onObtainCard(AbstractCard c) {}
    public void onGainGold() {}
    public void onLoseGold() {}
    public void onEquip() {}
    public void onUnequip() {}
    public void atPreBattle() {}
    public void atBattleStart() {}
    public void atBattleStartPreDraw() {}
    public void atTurnStart() {}
    public void onPlayerEndTurn() {}
    public void onBloodied() {}
    public void onNotBloodied() {}
    public void onManualDiscard() {}
    public void onUseCard(AbstractCard targetCard, UseCardAction useCardAction) {}
    public void onVictory() {}
    public void onMonsterDeath(AbstractMonster m) {}
    public int onPlayerGainBlock(int blockAmount) { return blockAmount; }
    public int onPlayerHeal(int healAmount) { return healAmount;}
    public void onMeditate() {}
    public void onEnergyRecharge() {}
    public void onRest() {}
    public void onRitual() {}
    public void onEnterRestRoom() {}
    public void onRefreshHand() {}
    public void onShuffle() {}
    public void onSmith() {}
    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target) {}
    public int onAttacked(DamageInfo info, int damageAmount) {return damageAmount;}
    public void onExhaust(AbstractCard card) {}
    public void onTrigger() {}
    public void onTrigger(AbstractCreature target) {}
    public boolean checkTrigger() {return false;}
    public void onEnterRoom(AbstractRoom room) {}
    public void onCardDraw(AbstractCard drawnCard) {}
    public void onChestOpen(boolean bossChest) {}
    public void onDrawOrDiscard() {}
    public void onMasterDeckChange() {}
}
