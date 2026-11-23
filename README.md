# CareerBoost

**CareerBoost** — Java 21 және Spring Boot негізіндегі мансаптық жоба. Бұл нұсқа VS Code-та Java файлдарын ашып, алты жобалау паттернінің жұмысын терминалда көрсетуге арналған.

## Қолданылатын технологиялар
- Java 21
- Spring Boot 3.5.7
- Maven
- H2 (in-memory)

## Маңызды: браузер қажет емес
CareerBoost console-only режимінде бапталған. Spring Boot веб-серверін іске қоспайды, браузер ашудың қажеті жоқ. Қосымша іске қосылғанда паттерндердің нәтижелері VS Code терминалына басылады да, бағдарлама аяқталады.

## VS Code-та ашу және іске қосу
1. JDK 21, Git, Maven және VS Code орнатыңыз.
2. VS Code ашыңыз → **Terminal → New Terminal**.
3. Репозиторийді жүктеңіз:
   ```bash
   git clone https://github.com/abdikadirovrasul170-cpu/CareerBoost.git
   ```
4. Жоба бумасына өтіңіз:
   ```bash
   cd CareerBoost
   ```
5. VS Code-та ашыңыз:
   ```bash
   code .
   ```
   Егер `code .` командасы істемесе, VS Code мәзірінен **File → Open Folder** таңдап, CareerBoost бумасын ашыңыз.
6. Java және Maven тексеріңіз:
   ```bash
   java -version
   mvn -version
   ```
7. Паттерндерді терминалда іске қосыңыз:
   ```bash
   mvn spring-boot:run
   ```

## Терминалда орындалатын 6 паттерн
1. **Builder** — Resume объектісін қадаммен құрады.
2. **Abstract Factory** — өзара үйлесімді UI компоненттерін жасайды.
3. **Template Method** — резюмені экспорттау қадамдарын реттейді.
4. **Strategy** — резюме бағалау алгоритмін ауыстырады.
5. **Adapter** — ескі резюме талдау класын жаңа интерфейске бейімдейді.
6. **Visitor** — резюме элементтеріне қосымша операция орындайды.

Демонстрация коды: `src/main/java/kz/careerboost/patterns/PatternDemoRunner.java`.

## Құжаттама
- [SRS — бағдарламалық талаптар](docs/SRS.md)
- [User Stories және acceptance criteria](docs/USER_STORIES.md)
- [Acceptance Criteria](docs/ACCEPTANCE_CRITERIA.md)
- [GitHub Milestones және Projects тақтасын баптау](docs/PROJECT_BOARD_SETUP.md)

## MVP
Тіркелу/кіру, профиль, резюме құру және өңдеу, үлгі таңдау, вакансиялар тізімі.

## Final
PDF экспорт, резюме бағалау, өтінім беру, әкімші панелі, тесттер және толық құжаттама.

## Жоба мәртебесі
Код GitHub репозиторийіне енгізілген. Нақты компиляция және орындалу нәтижесін жергілікті компьютерде `mvn spring-boot:run` арқылы тексеру қажет.
