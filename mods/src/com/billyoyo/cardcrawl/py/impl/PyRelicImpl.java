package com.billyoyo.cardcrawl.py.impl;

import com.billyoyo.cardcrawl.py.util.PyFiles;
import com.billyoyo.cardcrawl.py.api.RelicHelper;
import com.billyoyo.cardcrawl.py.interfaces.PyRelic;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.GameDictionary;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.Anchor;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by william on 24/01/2018.
 */
public class PyRelicImpl extends AbstractRelic {

    private static final String PLACEHOLDER_RELIC_ID = Anchor.ID;

    private final PyRelic relic;

    public static PyRelicImpl createRelic(PyRelic relic) {
        relic.setup(Settings.language.name());

        // if the image path starts with '/' it is found in the /pymods folder instead of in the jar
        String image = relic.getImage();
        boolean isImageAPath = image.startsWith("/");

        RelicTier tier = RelicHelper.getRelicTier(relic.getRelicTier());
        LandingSound sound = RelicHelper.getRelicLandingSound(relic.getLandingSound());

        LocalizedStrings oldPack = CardCrawlGame.languagePack;
        PyLocalizedStringsImpl overridePack = new PyLocalizedStringsImpl();
        overridePack.registerRelic(relic);

        CardCrawlGame.languagePack = overridePack;
        PyRelicImpl pyRelicImpl = null;
        try {
            pyRelicImpl = new PyRelicImpl(relic, tier, sound, image, isImageAPath);
        } finally {
            CardCrawlGame.languagePack = oldPack;
        }

        return pyRelicImpl;
    }

    private PyRelicImpl(PyRelic relic, RelicTier tier, LandingSound sound, String image, boolean isImageAPath) {
        // we give a placeholder as the id so that we don't get null exceptions when getting the language
        super(relic.getId(), isImageAPath ? "" : image, tier, sound);
        this.relic = relic;
        relic.impl = this;
        this.description = this.getUpdatedDescription();

        this.tips.clear();
        this.tips.add(new PowerTip(this.name, this.description));
        this.initializeTips();

        if (isImageAPath) {
            // e.g /examplemod/res/images/killalot.png
            //     /examplemod/res/images/killalot_big.png
            //     /examplemod/res/images/killalot_outline.png
            String path = image;
            String ext = "";
            if (image.contains(".")) {
                String[] tokens = PyFiles.splitByExtension(image);
                path = tokens[0];
                ext = tokens[1];
            }

            if (relic.pyModParent != null) {
                path = "/" + relic.pyModParent.folder + path;
            }

            this.img = PyFiles.getTexture(path + "." + ext);
            this.largeImg = PyFiles.getTexture(path + "_large." + ext);
            this.outlineImg = PyFiles.getTexture(path + "_outline." + ext);
        }
    }

    public String getRelicColour() {
        if (relic != null) {
            return relic.getRelicColor();
        }
        return null;
    }

    public String getUpdatedDescription() {
        if (relic != null) {
            return relic.getDescription();
        }
        return null;
    }

    @Override
    protected void initializeTips() {
        if (relic != null) {
            Scanner desc = new Scanner(this.description);

            while (desc.hasNext()) {
                String s = desc.next();
                String copy = "";
                if (s.charAt(0) == 35) {
                    s = s.substring(2);
                }

                s = s.replace(',', ' ');
                s = s.replace('.', ' ');
                s = s.trim();
                copy = new String(s);
                s = s.toLowerCase();
                boolean alreadyExists = false;
                Iterator var5 = this.tips.iterator();

                while (var5.hasNext()) {
                    PowerTip t = (PowerTip) var5.next();
                    if (t.header.toLowerCase().equals(copy.toLowerCase())) {
                        alreadyExists = true;
                        break;
                    }
                }

                if (!alreadyExists && GameDictionary.keywords.containsKey(s)) {
                    this.tips.add(new PowerTip(copy, (String) GameDictionary.keywords.get(s)));
                }
            }

            desc.close();
        }
    }

    @Override
    public AbstractRelic makeCopy() {
        return PyRelicImpl.createRelic(relic.copy());
    }

    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        relic.onPlayCard(c, m);
    }

    @Override
    public void onObtainCard(AbstractCard c) {
        relic.onObtainCard(c);
    }

    @Override
    public void onGainGold() {
        relic.onGainGold();
    }

    @Override
    public void onLoseGold() {
        relic.onLoseGold();
    }

    @Override
    public void onEquip() {
        relic.onEquip();
    }

    @Override
    public void onUnequip() {
        relic.onUnequip();
    }

    @Override
    public void atPreBattle() {
        relic.atPreBattle();
    }

    @Override
    public void atBattleStart() {
        relic.atBattleStart();
    }

    @Override
    public void atBattleStartPreDraw() {
        relic.atBattleStartPreDraw();
    }

    @Override
    public void atTurnStart() {
        relic.atTurnStart();
    }

    @Override
    public void onPlayerEndTurn() {
        relic.onPlayerEndTurn();
    }

    @Override
    public void onBloodied() {
        relic.onBloodied();
    }

    @Override
    public void onNotBloodied() {
        relic.onNotBloodied();
    }

    @Override
    public void onManualDiscard() {
        relic.onManualDiscard();
    }

    @Override
    public void onUseCard(AbstractCard targetCard, UseCardAction useCardAction) {
        relic.onUseCard(targetCard, useCardAction);
    }

    @Override
    public void onVictory() {
        relic.onVictory();
    }

    @Override
    public void onMonsterDeath(AbstractMonster m) {
        relic.onMonsterDeath(m);
    }

    @Override
    public int onPlayerGainBlock(int blockAmount) {
        return relic.onPlayerGainBlock(blockAmount);
    }

    @Override
    public int onPlayerHeal(int healAmount) {
        return relic.onPlayerHeal(healAmount);
    }

    @Override
    public void onMeditate() {
        relic.onMeditate();
    }

    @Override
    public void onEnergyRecharge() {
        relic.onEnergyRecharge();
    }

    @Override
    public void onRest() {
        relic.onRest();
    }

    @Override
    public void onRitual() {
        relic.onRitual();
    }

    @Override
    public void onEnterRestRoom() {
        relic.onEnterRestRoom();
    }

    @Override
    public void onRefreshHand() {
        relic.onRefreshHand();
    }

    @Override
    public void onShuffle() {
        relic.onShuffle();
    }

    @Override
    public void onSmith() {
        relic.onSmith();
    }

    @Override
    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target) {
        relic.onAttack(info, damageAmount, target);
    }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        return relic.onAttacked(info, damageAmount);
    }

    @Override
    public void onExhaust(AbstractCard card) {
        relic.onExhaust(card);
    }

    @Override
    public void onTrigger() {
        relic.onTrigger();
    }

    @Override
    public void onTrigger(AbstractCreature target) {
        relic.onTrigger(target);
    }

    @Override
    public boolean checkTrigger() {
        return relic.checkTrigger();
    }

    @Override
    public void onEnterRoom(AbstractRoom room) {
        relic.onEnterRoom(room);
    }

    @Override
    public void onCardDraw(AbstractCard drawnCard) {
        relic.onCardDraw(drawnCard);
    }

    @Override
    public void onChestOpen(boolean bossChest) {
        relic.onChestOpen(bossChest);
    }

    @Override
    public void onDrawOrDiscard() {
        relic.onDrawOrDiscard();
    }

    @Override
    public void onMasterDeckChange() {
        relic.onMasterDeckChange();
    }
}

