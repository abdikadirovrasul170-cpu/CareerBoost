# CareerBoost — Java консольдік жоба

CareerBoost — жұмыс іздеушілерге профиль құруға, түйіндемені талдауға және вакансиялармен жұмыс істеуге арналған оқу жобасы. Жоба Java 21, Spring Boot және Maven негізінде жасалған. Қосымша браузер ашпай, VS Code терминалында жұмыс істейді.

## Қолданылған Design Pattern-дер

1. **Builder** — түйіндемені кезең-кезеңімен құру.
2. **Abstract Factory** — Candidate және Recruiter рөлдеріне арналған үйлесімді интерфейс компоненттерін құру.
3. **Template Method** — түйіндемені тексеру/экспорттау алгоритмінің ретін бекіту.
4. **Strategy** — түйіндемені бағалау тәсілін ауыстыру.
5. **Adapter** — ескі талдау сервисін жаңа интерфейске бейімдеу.
6. **Visitor** — түйіндеме элементтеріне қосымша талдау жасау.

## VS Code-та ашу

Алғаш рет жүктеу:
```bash
git clone https://github.com/abdikadirovrasul170-cpu/CareerBoost.git
cd CareerBoost
code .
```

Егер жоба бұрыннан компьютерде болса:
```bash
git pull origin main
```

## Терминалдан іске қосу

Java 21 және Maven орнатылған болуы керек.

```bash
mvn spring-boot:run
```

Алты паттерннің орындалу нәтижесі VS Code терминалында көрсетіледі. Браузерді ашу қажет емес.

## JUnit 5 тесттерін орындау

```bash
mvn test
```

Тест есебі: `target/surefire-reports/`

## Тест құрылымы

- `BuilderTest.java` — түйіндеме құру және міндетті өрістерді тексеру.
- `AbstractFactoryTest.java` — UI компоненттерінің құрылуы.
- `TemplateMethodTest.java` — экспорттау және қате деректерді тексеру.
- `StrategyTest.java` — бағалау стратегиялары.
- `AdapterTest.java` — ескі сервисті жаңа интерфейс арқылы пайдалану.
- `VisitorTest.java` — түйіндеме элементтеріне Visitor қолдану.

Тесттер `src/test/java/kz/careerboost/patterns/` бумасында орналасқан.

## Негізгі құрылым

- `src/main/java/kz/careerboost/CareerBoostApplication.java` — бағдарламаның іске қосылу нүктесі.
- `src/main/java/kz/careerboost/patterns/PatternDemoRunner.java` — алты паттерннің демонстрациясы.
- `src/test/java/kz/careerboost/patterns/` — JUnit 5 тесттері.
- `pom.xml` — Maven конфигурациясы.
- `SRS.md`, `docs/` — талаптар, User Stories және жобаны жоспарлау құжаттары.

## Ескерту

Бұл — оқу прототипі. Нақты өндірістік жүйеге деректерді тұрақты сақтау, авторизация және толық вакансия басқару функцияларын кейін қосуға болады.
