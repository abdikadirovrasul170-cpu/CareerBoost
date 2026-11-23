package kz.careerboost.patterns;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("US-04, US-05. Түйіндемені экспорттау (Template Method)")
class TemplateMethodTest {

    @Test
    @DisplayName("US-04: дұрыс түйіндеме PDF форматына дайындалады")
    void exportsValidResume() {
        PatternDemoRunner.ResumeExporter exporter = new PatternDemoRunner.PdfResumeExporter();

        assertDoesNotThrow(() -> exporter.export("Расулдың түйіндемесі"));
    }

    @Test
    @DisplayName("US-05: бос түйіндемені экспорттауға болмайды")
    void rejectsBlankResume() {
        PatternDemoRunner.ResumeExporter exporter = new PatternDemoRunner.PdfResumeExporter();

        assertThrows(IllegalArgumentException.class, () -> exporter.export(" "));
    }

    @Test
    @DisplayName("US-05: null түйіндеме қабылданбайды")
    void rejectsNullResume() {
        PatternDemoRunner.ResumeExporter exporter = new PatternDemoRunner.PdfResumeExporter();

        assertThrows(IllegalArgumentException.class, () -> exporter.export(null));
    }
}
