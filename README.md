# CareerBoost — Java / Spring Boot жобасы

CareerBoost — жұмыс іздеушілерге арналған мансап платформасының оқу прототипі. Жоба Java 21, Spring Boot және Maven негізінде жасалған. Қосымша іске қосылғанда алты GoF паттернінің демонстрациясы терминалға шығады.

## Қолданылған Design Pattern-дер

1. **Builder** — түйіндемені кезең-кезеңімен құру.
2. **Abstract Factory** — интерфейс компоненттерінің үйлесімді тобын құру.
3. **Template Method** — түйіндемені экспорттау алгоритмінің ретін бекіту.
4. **Strategy** — түйіндемені бағалау алгоритмін ауыстыру.
5. **Adapter** — ескі талдау сервисін жаңа интерфейске бейімдеу.
6. **Visitor** — түйіндеме элементтеріне қосымша талдау жасау.

## VS Code-та ашу

```bash
git clone https://github.com/abdikadirovrasul170-cpu/CareerBoost.git
cd CareerBoost
code .
```

## Жобаны іске қосу

Java 21 және Maven қажет. VS Code Terminal ішінде:

```bash
mvn spring-boot:run
```

Браузерден ашу: http://localhost:8080

Алты паттерннің орындалу нәтижесі VS Code терминалында көрсетіледі.

## JUnit 5 тесттерін орындау

Барлық автоматты тесттерді іске қосу:

```bash
mvn test
```

Тест нәтижелерінің есебі:

```text
target/surefire-reports/
```

## Тест құрылымы

- `BuilderTest.java` — профиль/түйіндеме құру және міндетті өрістерді тексеру.
- `AbstractFactoryTest.java` — UI компоненттерінің құрылуын тексеру.
- `TemplateMethodTest.java` — бос емес түйіндемені экспорттау және қате деректерді қабылдамау.
- `StrategyTest.java` — бағалау стратегиялары мен оларды ауыстыру.
- `AdapterTest.java` — ескі талдау сервисін жаңа интерфейс арқылы пайдалану.
- `VisitorTest.java` — дағды және тәжірибе элементтеріне Visitor қолдану.

Тесттер `src/test/java/kz/careerboost/patterns/` бумасында орналасқан.

## Негізгі құрылым

- `src/main/java/kz/careerboost/` — Spring Boot қосымшасы.
- `src/main/java/kz/careerboost/patterns/PatternDemoRunner.java` — алты паттерннің демонстрациясы.
- `src/main/resources/templates/index.html` — бастапқы веб-бет.
- `src/test/java/kz/careerboost/patterns/` — JUnit 5 автоматты тесттері.
- `pom.xml` — Maven тәуелділіктері мен Java нұсқасы.
- `SRS.md` және `docs/` — талаптар мен жоба құжаттары.

## Ескерту

Бұл — оқу прототипі. Нақты өндірістік жүйеге дерекқор, авторизация, қауіпсіздік және толыққанды вакансия басқару функцияларын қосымша дамыту қажет.
