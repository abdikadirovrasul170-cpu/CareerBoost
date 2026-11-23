# CareerBoost — Java Console MVP
CareerBoost — кандидат пен рекрутерге арналған Java 21 консольдік оқу прототипі. Браузер мен веб-сервер қажет емес.

## Іске қосу
JDK 21 және Maven 3.9+ қажет.
```bash
mvn test
mvn compile
java -cp target/classes kz.careerboost.CareerBoostApplication
```

## User Stories және Design Patterns
| User Story | Функция | Паттерн |
|---|---|---|
| US-01, US-02 | Профиль құру және толтыру | Builder |
| US-03 | Candidate/Recruiter компоненттері | Abstract Factory |
| US-04, US-05 | Түйіндемені тексеру | Template Method |
| US-06, US-07 | Вакансияларды сұрыптау | Strategy |
| US-08, US-09 | Сыртқы вакансияны түрлендіру | Adapter |
| US-10, US-11 | Профиль және вакансия есебі | Visitor |
| US-12 | Консоль мәзірі | Барлығы |

## VS Code
1. CareerBoost бумасын ашыңыз.
2. Extension Pack for Java орнатыңыз.
3. Terminal → New Terminal ашыңыз.
4. `mvn test` орындаңыз.
5. Жоғарыдағы java командасымен іске қосыңыз.
