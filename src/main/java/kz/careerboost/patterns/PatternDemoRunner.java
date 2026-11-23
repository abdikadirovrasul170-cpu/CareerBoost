package kz.careerboost.patterns;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

// All six design patterns are demonstrated when the Spring Boot application starts.
// Their output is printed to the VS Code terminal.
@Component
public class PatternDemoRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("\n========== CAREERBOOST DESIGN PATTERNS ==========");

        builderDemo();
        abstractFactoryDemo();
        templateMethodDemo();
        strategyDemo();
        adapterDemo();
        visitorDemo();

        System.out.println("========== ALL PATTERN DEMOS COMPLETED ==========\n");
    }

    // 1. BUILDER: creates a Resume step by step.
    private void builderDemo() {
        Resume resume = new Resume.Builder()
                .name("Aruzhan")
                .position("Java Developer")
                .skills(List.of("Java", "Spring Boot", "SQL"))
                .build();

        System.out.println("\n[Builder] " + resume);
    }

    static class Resume {
        private final String name;
        private final String position;
        private final List<String> skills;

        private Resume(Builder builder) {
            this.name = builder.name;
            this.position = builder.position;
            this.skills = List.copyOf(builder.skills);
        }

        @Override
        public String toString() {
            return "Resume{name='" + name + "', position='" + position
                    + "', skills=" + skills + "}";
        }

        static class Builder {
            private String name;
            private String position;
            private List<String> skills = List.of();

            Builder name(String name) {
                this.name = name;
                return this;
            }

            Builder position(String position) {
                this.position = position;
                return this;
            }

            Builder skills(List<String> skills) {
                this.skills = skills;
                return this;
            }

            Resume build() {
                if (name == null || position == null) {
                    throw new IllegalStateException("Name and position are required");
                }
                return new Resume(this);
            }
        }
    }

    // 2. ABSTRACT FACTORY: creates a matching set of UI components.
    private void abstractFactoryDemo() {
        UiFactory factory = new ProfessionalUiFactory();
        System.out.println("\n[Abstract Factory] " + factory.createButton().render());
        System.out.println("[Abstract Factory] " + factory.createCard().render());
    }

    interface Button { String render(); }
    interface Card { String render(); }
    interface UiFactory {
        Button createButton();
        Card createCard();
    }

    static class ProfessionalUiFactory implements UiFactory {
        public Button createButton() {
            return () -> "Professional button";
        }
        public Card createCard() {
            return () -> "Professional resume card";
        }
    }

    // 3. TEMPLATE METHOD: fixes the resume export steps, subclasses customize a step.
    private void templateMethodDemo() {
        ResumeExporter exporter = new PdfResumeExporter();
        exporter.export("Aruzhan's resume");
    }

    abstract static class ResumeExporter {
        public final void export(String resume) {
            validate(resume);
            format(resume);
            System.out.println("[Template Method] Resume exported as " + formatName());
        }
        private void validate(String resume) {
            if (resume == null || resume.isBlank()) {
                throw new IllegalArgumentException("Resume cannot be empty");
            }
        }
        protected abstract void format(String resume);
        protected abstract String formatName();
    }

    static class PdfResumeExporter extends ResumeExporter {
        protected void format(String resume) {
            System.out.println("[Template Method] Preparing PDF: " + resume);
        }
        protected String formatName() {
            return "PDF";
        }
    }

    // 4. STRATEGY: scoring algorithm can be changed at runtime.
    private void strategyDemo() {
        ResumeScorer scorer = new ResumeScorer(new BalancedScoring());
        System.out.println("\n[Strategy] Balanced score: " + scorer.score(4, 3));
        scorer.setStrategy(new SkillFocusedScoring());
        System.out.println("[Strategy] Skill-focused score: " + scorer.score(4, 3));
    }

    interface ScoringStrategy {
        int calculate(int skills, int experienceYears);
    }

    static class BalancedScoring implements ScoringStrategy {
        public int calculate(int skills, int experienceYears) {
            return Math.min(100, skills * 15 + experienceYears * 5);
        }
    }

    static class SkillFocusedScoring implements ScoringStrategy {
        public int calculate(int skills, int experienceYears) {
            return Math.min(100, skills * 20 + experienceYears * 2);
        }
    }

    static class ResumeScorer {
        private ScoringStrategy strategy;
        ResumeScorer(ScoringStrategy strategy) {
            this.strategy = strategy;
        }
        void setStrategy(ScoringStrategy strategy) {
            this.strategy = strategy;
        }
        int score(int skills, int experienceYears) {
            return strategy.calculate(skills, experienceYears);
        }
    }

    // 5. ADAPTER: adapts a legacy CV analysis service to the new interface.
    private void adapterDemo() {
        ResumeAnalysis analysis = new LegacyAnalysisAdapter(new LegacyResumeAnalyzer());
        System.out.println("\n[Adapter] " + analysis.analyze("Java Spring SQL"));
    }

    interface ResumeAnalysis {
        String analyze(String resumeText);
    }

    static class LegacyResumeAnalyzer {
        String oldAnalyzeMethod(String text) {
            return "Legacy analyzer found " + text.split("\\s+").length + " keywords";
        }
    }

    static class LegacyAnalysisAdapter implements ResumeAnalysis {
        private final LegacyResumeAnalyzer legacy;
        LegacyAnalysisAdapter(LegacyResumeAnalyzer legacy) {
            this.legacy = legacy;
        }
        public String analyze(String resumeText) {
            return legacy.oldAnalyzeMethod(resumeText);
        }
    }

    // 6. VISITOR: adds operations to resume elements without changing their classes.
    private void visitorDemo() {
        List<ResumeElement> elements = List.of(
                new SkillElement("Java"),
                new ExperienceElement("2 years Java development")
        );
        ResumeVisitor visitor = new ResumeSummaryVisitor();
        elements.forEach(element -> element.accept(visitor));
    }

    interface ResumeElement {
        void accept(ResumeVisitor visitor);
    }

    interface ResumeVisitor {
        void visit(SkillElement skill);
        void visit(ExperienceElement experience);
    }

    static class SkillElement implements ResumeElement {
        private final String name;
        SkillElement(String name) { this.name = name; }
        String name() { return name; }
        public void accept(ResumeVisitor visitor) { visitor.visit(this); }
    }

    static class ExperienceElement implements ResumeElement {
        private final String description;
        ExperienceElement(String description) { this.description = description; }
        String description() { return description; }
        public void accept(ResumeVisitor visitor) { visitor.visit(this); }
    }

    static class ResumeSummaryVisitor implements ResumeVisitor {
        public void visit(SkillElement skill) {
            System.out.println("\n[Visitor] Resume skill: " + skill.name());
        }
        public void visit(ExperienceElement experience) {
            System.out.println("[Visitor] Resume experience: " + experience.description());
        }
    }
}
