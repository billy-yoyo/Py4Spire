package com.billyoyo.cardcrawl.py.impl;

import com.badlogic.gdx.graphics.Texture;
import com.billyoyo.cardcrawl.py.api.CardHelper;
import com.billyoyo.cardcrawl.py.interfaces.PyCard;
import com.billyoyo.cardcrawl.py.util.PyFiles;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

/**
 * Created by william on 25/01/2018.
 */
public class PyCardImpl extends AbstractCard {

    // 'pool' unused, so value of this no longer matters
    private static final int PLACEHOLDER_POOL_NUMER = 2;

    public static PyCardImpl createCard(PyCard card) {
        card.setup(Settings.language.name());

        String imageUrl = card.getImage();
        boolean imageUrlIsAPath = imageUrl.startsWith("/");

        return new PyCardImpl(card, card.getId(), card.getName(), imageUrl, card.getCost(), card.getDescription(),
                CardHelper.getCardType(card.getCardType()), CardHelper.getCardColor(card.getColor()),
                CardHelper.getCardRarity(card.getRarity()), CardHelper.getCardTarget(card.getTarget()),
                PLACEHOLDER_POOL_NUMER, imageUrlIsAPath);
    }

    private final PyCard card;
    private Texture cachedPortraitImg;
    private boolean imageUrlIsAPath;

    private PyCardImpl(PyCard card, String id, String name, String imgUrl, int cost, String rawDescription,
            CardType type, CardColor color, CardRarity rarity, CardTarget target, int cardPool,
            boolean imageUrlIsAPath) {
        super(id, name, "", imageUrlIsAPath ? "" : imgUrl, cost, rawDescription, type,
                color, rarity, target, cardPool);
        this.card = card;
        card.impl = this;
        this.imageUrlIsAPath = imageUrlIsAPath;

        if (imageUrlIsAPath) {
            if (card.pyModParent != null) {
                imgUrl = "/" + card.pyModParent.folder + imgUrl;
            }

            this.portraitImg = PyFiles.getTexture(imgUrl);
            this.cachedPortraitImg = this.portraitImg;
        }
    }

    @Override
    public void unlock() {
        if (imageUrlIsAPath) {
            this.isLocked = false;
            this.portraitImg = cachedPortraitImg;
        } else {
            super.unlock();
        }
    }

    @Override
    public void upgrade() {
        card.upgrade();
    }

    @Override
    public AbstractCard makeCopy() {
        return PyCardImpl.createCard(card.copy());
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        card.use(abstractPlayer, abstractMonster);
    }

    @Override
    public boolean canPlay(AbstractCard card) {
        return this.card.canPlay(card);
    }

    @Override
    public void tookDamage() {
        card.tookDamage();
    }

    @Override
    public void didDiscard() {
        card.didDiscard();
    }

    @Override
    public void triggerWhenDrawn() {
        card.triggerWhenDrawn();
    }

    @Override
    public void triggerOnEndOfPlayerTurn() {
        card.triggerOnEndOfPlayerTurn();
    }

    @Override
    public void triggerOnEndOfTurnForPlayingCard() {
        card.triggerOnEndOfTurnForPlayingCard();
    }

    @Override
    public void triggerOnOtherCardPlayed(AbstractCard c) {
        card.triggerOnOtherCardPlayed(c);
    }

    @Override
    public void triggerOnGainEnergy(int e, boolean dueToCard) {
        card.triggerOnGainEnergy(e, dueToCard);
    }

    @Override
    public void triggerOnManualDiscard() {
        card.triggerOnManualDiscard();
    }

    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        card.onPlayCard(c, m);
    }

    @Override
    public void atTurnStart() {
        card.atTurnStart();
    }

    @Override
    public void triggerOnExhaust() {
        card.triggerOnExhaust();
    }

    @Override
    public void onMoveToDiscard() {
        card.onMoveToDiscard();
    }
}

