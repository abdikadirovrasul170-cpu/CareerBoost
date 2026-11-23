package kz.careerboost.patterns;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("US-01, US-02. Профиль құру (Builder)")
class BuilderTest {

    @Test
    @DisplayName("US-01: аты, лауазымы және дағдылары бар түйіндеме құрылады")
    void createsCompleteResume() {
        PatternDemoRunner.Resume resume = new PatternDemoRunner.Resume.Builder()
                .name("Расул")
                .position("Java Developer")
                .skills(List.of("Java", "Spring Boot", "SQL"))
                .build();

        assertTrue(resume.toString().contains("Расул"));
        assertTrue(resume.toString().contains("Java Developer"));
        assertTrue(resume.toString().contains("Spring Boot"));
    }

    @Test
    @DisplayName("US-02: міндетті аты берілмесе қате шығады")
    void missingNameRejected() {
        assertThrows(IllegalStateException.class, () ->
                new PatternDemoRunner.Resume.Builder()
                        .position("Java Developer")
                        .build());
    }

    @Test
    @DisplayName("US-02: міндетті лауазым берілмесе қате шығады")
    void missingPositionRejected() {
        assertThrows(IllegalStateException.class, () ->
                new PatternDemoRunner.Resume.Builder()
                        .name("Расул")
                        .build());
    }
}
