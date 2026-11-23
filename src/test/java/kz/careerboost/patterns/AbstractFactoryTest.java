package kz.careerboost.patterns;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("US-03. UI компоненттері (Abstract Factory)")
class AbstractFactoryTest {

    @Test
    @DisplayName("US-03: фабрика батырма компонентін жасайды")
    void createsButton() {
        PatternDemoRunner.UiFactory factory = new PatternDemoRunner.ProfessionalUiFactory();

        assertEquals("Professional button", factory.createButton().render());
    }

    @Test
    @DisplayName("US-03: фабрика түйіндеме карточкасын жасайды")
    void createsResumeCard() {
        PatternDemoRunner.UiFactory factory = new PatternDemoRunner.ProfessionalUiFactory();

        assertEquals("Professional resume card", factory.createCard().render());
    }

    @Test
    @DisplayName("US-03: бір фабрика үйлесімді компоненттер тобын қайтарады")
    void createsCompatibleComponents() {
        PatternDemoRunner.UiFactory factory = new PatternDemoRunner.ProfessionalUiFactory();

        assertNotNull(factory.createButton());
        assertNotNull(factory.createCard());
    }
}
