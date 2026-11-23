package kz.careerboost.patterns;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("US-10, US-11. Түйіндеме элементтерін талдау (Visitor)")
class VisitorTest {

    static class CountingVisitor implements PatternDemoRunner.ResumeVisitor {
        int skillVisits;
        int experienceVisits;

        @Override
        public void visit(PatternDemoRunner.SkillElement skill) {
            skillVisits++;
        }

        @Override
        public void visit(PatternDemoRunner.ExperienceElement experience) {
            experienceVisits++;
        }
    }

    @Test
    @DisplayName("US-10: Visitor дағды элементін қабылдайды")
    void visitsSkill() {
        CountingVisitor visitor = new CountingVisitor();
        PatternDemoRunner.ResumeElement element =
                new PatternDemoRunner.SkillElement("Java");

        element.accept(visitor);

        assertEquals(1, visitor.skillVisits);
        assertEquals(0, visitor.experienceVisits);
    }

    @Test
    @DisplayName("US-11: Visitor тәжірибе элементін қабылдайды")
    void visitsExperience() {
        CountingVisitor visitor = new CountingVisitor();
        PatternDemoRunner.ResumeElement element =
                new PatternDemoRunner.ExperienceElement("2 жыл Java");

        element.accept(visitor);

        assertEquals(0, visitor.skillVisits);
        assertEquals(1, visitor.experienceVisits);
    }

    @Test
    @DisplayName("US-11: Visitor екі түрлі элементті де талдайды")
    void visitsAllResumeElements() {
        CountingVisitor visitor = new CountingVisitor();

        new PatternDemoRunner.SkillElement("SQL").accept(visitor);
        new PatternDemoRunner.ExperienceElement("1 жыл").accept(visitor);

        assertEquals(1, visitor.skillVisits);
        assertEquals(1, visitor.experienceVisits);
    }
}
