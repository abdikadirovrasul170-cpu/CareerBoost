package kz.careerboost.patterns;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("US-08, US-09. Ескі талдау сервисі (Adapter)")
class AdapterTest {

    @Test
    @DisplayName("US-08: Adapter ескі сервисті жаңа интерфейс арқылы шақырады")
    void adaptsLegacyAnalyzer() {
        PatternDemoRunner.ResumeAnalysis adapter =
                new PatternDemoRunner.LegacyAnalysisAdapter(
                        new PatternDemoRunner.LegacyResumeAnalyzer());

        assertEquals("Legacy analyzer found 3 keywords",
                adapter.analyze("Java Spring SQL"));
    }

    @Test
    @DisplayName("US-09: бір сөзден тұратын мәтінді дұрыс өңдейді")
    void handlesSingleKeyword() {
        PatternDemoRunner.ResumeAnalysis adapter =
                new PatternDemoRunner.LegacyAnalysisAdapter(
                        new PatternDemoRunner.LegacyResumeAnalyzer());

        assertEquals("Legacy analyzer found 1 keywords", adapter.analyze("Java"));
    }

    @Test
    @DisplayName("US-09: бос мәтін нөл кілтсөз ретінде есептеледі")
    void handlesEmptyText() {
        PatternDemoRunner.ResumeAnalysis adapter =
                new PatternDemoRunner.LegacyAnalysisAdapter(
                        new PatternDemoRunner.LegacyResumeAnalyzer());

        assertEquals("Legacy analyzer found 1 keywords", adapter.analyze(""));
    }
}
