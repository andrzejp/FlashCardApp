package io.prochyra.flashcardapp.domain;

public class Card {

    private final String definition;
    private final String concept;
    private boolean isFlipped;
    private int confidenceLevel;

    public Card(String concept, String definition) {
        this.concept = concept;
        this.definition = definition;
    }

    public String content() {
        return isFlipped ? definition : concept;
    }

    public void flip() {
        requireCardNotFlipped();
        isFlipped = true;
    }

    private void requireCardNotFlipped() {
        if (isFlipped) {
            throw new IllegalStateException("Card already flipped");
        }
    }

    public void recordConfidence(int confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
    }

    public int confidence() {
        return confidenceLevel;
    }
}
