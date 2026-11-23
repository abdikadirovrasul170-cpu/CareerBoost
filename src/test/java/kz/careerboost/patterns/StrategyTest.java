package kz.careerboost.patterns;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("US-06, US-07. Түйіндемені бағалау (Strategy)")
class StrategyTest {

    @Test
    @DisplayName("US-06: Balanced стратегиясы дағды мен тәжірибені бірге есептейді")
    void balancedScoring() {
        PatternDemoRunner.ResumeScorer scorer =
                new PatternDemoRunner.ResumeScorer(new PatternDemoRunner.BalancedScoring());

        assertEquals(75, scorer.score(4, 3));
    }

    @Test
    @DisplayName("US-07: SkillFocused стратегиясы дағдыға көбірек мән береді")
    void skillFocusedScoring() {
        PatternDemoRunner.ResumeScorer scorer =
                new PatternDemoRunner.ResumeScorer(new PatternDemoRunner.SkillFocusedScoring());

        assertEquals(86, scorer.score(4, 3));
    }

    @Test
    @DisplayName("US-07: стратегияны орындау кезінде ауыстыруға болады")
    void switchesStrategyAtRuntime() {
        PatternDemoRunner.ResumeScorer scorer =
                new PatternDemoRunner.ResumeScorer(new PatternDemoRunner.BalancedScoring());

        int firstScore = scorer.score(4, 3);
        scorer.setStrategy(new PatternDemoRunner.SkillFocusedScoring());

        assertEquals(75, firstScore);
        assertEquals(86, scorer.score(4, 3));
    }

    @Test
    @DisplayName("US-07: балл 100-ден аспайды")
    void scoreIsLimitedTo100() {
        PatternDemoRunner.ResumeScorer scorer =
                new PatternDemoRunner.ResumeScorer(new PatternDemoRunner.BalancedScoring());

        assertEquals(100, scorer.score(10, 10));
    }
}
