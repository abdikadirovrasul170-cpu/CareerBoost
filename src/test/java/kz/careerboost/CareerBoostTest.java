package kz.careerboost;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static kz.careerboost.CareerBoost.*;
class CareerBoostTest {
 private Profile profile(){return new ProfileBuilder().name("Расул").email("r@test.kz").skills(List.of("Java","SQL")).experienceYears(2).build();}
 private List<Vacancy> jobs(){return List.of(new Vacancy("Java","A",700000),new Vacancy("Backend","B",900000));}
 @Test void builderValidatesAndBuilds(){assertEquals("Расул",profile().name());assertThrows(IllegalStateException.class,()->new ProfileBuilder().build());assertThrows(IllegalArgumentException.class,()->new ProfileBuilder().name("A").email("bad").build());}
 @Test void abstractFactoryCreatesRoleComponents(){assertTrue(factoryFor(Role.CANDIDATE).createButton().render().contains("Кандидат"));assertTrue(factoryFor(Role.RECRUITER).createCard().render().contains("Рекрутер"));}
 @Test void templateMethodChecksResume(){assertTrue(new StandardResumeChecker().check(profile()).valid());Profile p=new ProfileBuilder().name("A").email("a@b.kz").build();assertFalse(new StandardResumeChecker().check(p).valid());}
 @Test void strategySortsAndCanChange(){VacancySorter s=new VacancySorter(new SalaryDescendingStrategy());assertEquals(900000,s.sort(jobs()).get(0).salary());s.setStrategy(new TitleAscendingStrategy());assertEquals("Backend",s.sort(jobs()).get(0).title());}
 @Test void adapterConvertsExternalVacancy(){Vacancy v=new LegacyVacancyAdapter(new ExternalVacancy("QA","Lab","500 000 KZT")).toVacancy();assertEquals(500000,v.salary());assertThrows(IllegalArgumentException.class,()->new LegacyVacancyAdapter(new ExternalVacancy("QA","Lab","n/a")).toVacancy());}
 @Test void visitorCreatesProfileAndVacancyReports(){SummaryVisitor v=new SummaryVisitor();new ProfileElement(profile()).accept(v);new VacancyElement(jobs().get(0)).accept(v);assertEquals(2,v.reports().size());assertTrue(v.reports().get(0).contains("дағдылар саны: 2"));}
}