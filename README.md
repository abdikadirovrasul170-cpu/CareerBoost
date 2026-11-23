# CareerBoost

**CareerBoost** — Java 21 және Spring Boot негізіндегі мансаптық портал. Жүйе пайдаланушыларға профиль жүргізуге, түйіндеме (резюме) құруға және бос жұмыс орындарын қарауға мүмкіндік береді.

## Технологиялар
- Java 21
- Spring Boot 3.5
- Maven
- Spring Web, Thymeleaf
- Spring Data JPA, H2 Database
- Jakarta Bean Validation

## Жобаны VS Code арқылы іске қосу
1. Компьютерге JDK 21, Git, Maven және VS Code орнатыңыз.
2. VS Code ашыңыз: **Terminal → New Terminal**.
3. Репозиторийді жүктеңіз:
   `git clone https://github.com/abdikadirovrasul170-cpu/CareerBoost.git`
4. Жоба бумасына өтіңіз:
   `cd CareerBoost`
5. VS Code-та жобаны ашыңыз:
   `code .`
   Егер команда жұмыс істемесе, **File → Open Folder** арқылы CareerBoost бумасын таңдаңыз.
6. Терминалда Java және Maven нұсқаларын тексеріңіз:
   `java -version`
   `mvn -version`
7. Қосымшаны іске қосыңыз:
   `mvn spring-boot:run`
8. Браузерден ашыңыз: http://localhost:8080

Spring Boot іске қосылған кезде алты паттерннің демонстрациясы VS Code терминалына автоматты түрде шығады. Оны іске қосатын класс: `src/main/java/kz/careerboost/patterns/PatternDemoRunner.java`.

## Қолданылған Design Patterns
- **Builder** — Resume объектісін кезең-кезеңімен құру.
- **Abstract Factory** — интерфейс компоненттерінің өзара үйлесімді тобын құру.
- **Template Method** — резюмені экспорттау алгоритмінің қадамдарын бекіту.
- **Strategy** — резюме бағалау алгоритмін жұмыс кезінде ауыстыру.
- **Adapter** — ескі резюме талдау сервисін жаңа интерфейске бейімдеу.
- **Visitor** — резюме элементтеріне қосымша операция орындау.

## Құжаттама
- [SRS — бағдарламалық талаптар](docs/SRS.md)
- [User Stories](docs/USER_STORIES.md)
- [Acceptance Criteria](docs/ACCEPTANCE_CRITERIA.md)
- [GitHub Milestones және Projects тақтасын баптау нұсқаулығы](docs/PROJECT_BOARD_SETUP.md)

## MVP шекарасы
MVP құрамына тіркелу/кіру, пайдаланушы профилі, резюме құру және өңдеу, резюме үлгісін таңдау және бос жұмыс орындарын қарау кіреді.

## Final кезеңі
PDF экспорты, резюмені бағалау, жұмысқа өтінім беру, әкімші панелі, толық тестілеу және қосымша интеграциялар Final кезеңіне жоспарланады.

## Жоба мәртебесі
Жоба әзірлеу сатысында. Міндеттер GitHub Issues арқылы бақыланады. Қосымшаның нақты жұмысын тек жергілікті ортада іске қосып тексергеннен кейін растауға болады.
