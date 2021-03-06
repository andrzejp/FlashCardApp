package io.prochyra.flashcardapp.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DeckTest {

    @Test
    void givesACountOfHighConfidenceCards() {
        Card unknownConfidenceCard1 = new Card("concept", "definition");
        Card unknownConfidenceCard2 = new Card("concept", "definition");
        Card highConfidenceCard = new Card("concept", "definition", Confidence.HIGH);
        Deck deck = new Deck(List.of(unknownConfidenceCard1, unknownConfidenceCard2, highConfidenceCard));

        assertThat(deck.highConfidenceCount())
                .isOne();
    }

    @Test
    void givesTotalCountOfCards() {
        List<Card> threeCards = List.of(
                new Card("a", "a"),
                new Card("b", "b"),
                new Card("c", "c")
        );

        Deck deck = new Deck(threeCards);

        assertThat(deck.totalCardCount())
                .isEqualTo(3);
    }

    @Test
    void givesCountOfMediumConfidenceCards() {
        Card mediumConfidenceCard = new Card("x", "x", Confidence.MEDIUM);
        Deck deck = new Deck(List.of(mediumConfidenceCard));

        assertThat(deck.mediumConfidenceCount())
                .isOne();
    }

    @Test
    void givesCountOfLowConfidenceCards() {
        Card lowConfidenceCard = new Card("x", "x", Confidence.LOW);
        Deck deck = new Deck(List.of(lowConfidenceCard));

        assertThat(deck.lowConfidenceCount())
                .isOne();
    }
}
