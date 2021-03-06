package io.prochyra.flashcardapp.domain;

import java.util.Iterator;

public class StudySession {
    private final Iterator<Card> cardIterator;
    private int cardCount;
    private Card currentCard;

    public StudySession(Deck deck, int cardCount) {
        requireOneOrMoreCards(cardCount);
        requireEnoughCardsInDeck(deck, cardCount);
        cardIterator = deck.iterator();
        this.cardCount = cardCount;
    }

    public Card nextCard() {
        cardCount--;
        currentCard = cardIterator.next();
        return currentCard;
    }

    public boolean hasNextCard() {
        return cardCount > 0;
    }

    private void requireOneOrMoreCards(int cardCount) {
        if (cardCount <= 0) {
            throw new IllegalArgumentException("Study session must have at least one card.");
        }
    }

    private void requireEnoughCardsInDeck(Deck deck, int cardCount) {
        if (cardCount > deck.totalCardCount()) {
            throw new IllegalArgumentException(String.format("Can't create session of %d cards from deck with only %d.",
                    cardCount, deck.totalCardCount()));
        }
    }

    public Card currentCard() {
        return currentCard;
    }
}
