package io.prochyra.flashcardapp.adapter.out.jpa;

import io.prochyra.flashcardapp.domain.Confidence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CardDboTest {

    @Autowired
    CardJpaRepository cardJpaRepository;

    @Test
    void storedCardDboIsRetrievedFromJpaRepositoryWithIdAssigned() {
        CardDbo cardDbo = new CardDbo();
        cardDbo.setConcept("concept");
        cardDbo.setDefinition("definition");
        cardDbo.setConfidence(Confidence.UNKNOWN);

        cardJpaRepository.save(cardDbo);

        assertThat(cardJpaRepository.count())
                .isEqualTo(1L);

        CardDbo foundCardDbo = cardJpaRepository.findAll()
                                                .stream()
                                                .findFirst()
                                                .get();
        assertThat(foundCardDbo.getId())
                .isNotNull();
        assertThat(foundCardDbo)
                .extracting("concept", "definition", "confidence")
                .containsExactly("concept", "definition", Confidence.UNKNOWN);
    }
}
