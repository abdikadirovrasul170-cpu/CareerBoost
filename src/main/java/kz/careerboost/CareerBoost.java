package kz.careerboost;
import java.util.*;
/** CareerBoost MVP: domain logic and six GoF design patterns. */
public final class CareerBoost {
 private CareerBoost(){}
 public enum Role{CANDIDATE,RECRUITER}
 public record Profile(String name,String email,Role role,List<String> skills,int experienceYears,String summary){
  public Profile{name=requireText(name,"Аты");email=requireText(email,"Email");if(!email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$"))throw new IllegalArgumentException("Email форматы дұрыс емес");Objects.requireNonNull(role);if(experienceYears<0)throw new IllegalArgumentException("Тәжірибе теріс болмауы керек");skills=skills==null?List.of():List.copyOf(skills);summary=summary==null?"":summary.trim();}
 }
 // US-01, US-02 — BUILDER
 public static final class ProfileBuilder{
  private String name,email,summary="";private Role role=Role.CANDIDATE;private List<String>skills=new ArrayList<>();private int experienceYears;
  public ProfileBuilder name(String v){name=v;return this;}public ProfileBuilder email(String v){email=v;return this;}public ProfileBuilder role(Role v){role=v;return this;}
  public ProfileBuilder addSkill(String v){String s=requireText(v,"Дағды");if(!skills.contains(s))skills.add(s);return this;}
  public ProfileBuilder skills(Collection<String>v){skills=new ArrayList<>();if(v!=null)v.forEach(this::addSkill);return this;}
  public ProfileBuilder experienceYears(int v){experienceYears=v;return this;}public ProfileBuilder summary(String v){summary=v;return this;}
  public Profile build(){if(name==null||name.isBlank())throw new IllegalStateException("Аты міндетті");if(email==null||email.isBlank())throw new IllegalStateException("Email міндетті");return new Profile(name,email,role,skills,experienceYears,summary);}
 }
 // US-03 — ABSTRACT FACTORY
 public interface Button{String render();}public interface Card{String render();}public interface UiFactory{Button createButton();Card createCard();}
 public static final class CandidateFactory implements UiFactory{public Button createButton(){return()->"Кандидат: профильді сақтау";}public Card createCard(){return()->"Кандидат профилі картасы";}}
 public static final class RecruiterFactory implements UiFactory{public Button createButton(){return()->"Рекрутер: вакансия жариялау";}public Card createCard(){return()->"Рекрутер вакансия картасы";}}
 public static UiFactory factoryFor(Role r){return switch(Objects.requireNonNull(r)){case CANDIDATE->new CandidateFactory();case RECRUITER->new RecruiterFactory();};}
 public record Vacancy(String title,String company,int salary){public Vacancy{title=requireText(title,"Лауазым");company=requireText(company,"Компания");if(salary<0)throw new IllegalArgumentException("Жалақы теріс болмауы керек");}}
 // US-04, US-05 — TEMPLATE METHOD
 public record ResumeCheck(List<String>warnings,String conclusion){public ResumeCheck{warnings=List.copyOf(warnings);}public boolean valid(){return warnings.isEmpty();}}
 public abstract static class ResumeChecker{
  public final ResumeCheck check(Profile p){Objects.requireNonNull(p);List<String>w=new ArrayList<>();checkName(p,w);checkEmail(p,w);checkSkills(p,w);checkExperience(p,w);return new ResumeCheck(w,w.isEmpty()?"Түйіндеме тексеруден сәтті өтті":"Түйіндемені толықтыру қажет");}
  protected void checkName(Profile p,List<String>w){if(p.name().isBlank())w.add("Аты көрсетілмеген");}protected void checkEmail(Profile p,List<String>w){if(p.email().isBlank())w.add("Email көрсетілмеген");}
  protected abstract void checkSkills(Profile p,List<String>w);protected void checkExperience(Profile p,List<String>w){if(p.experienceYears()==0)w.add("Жұмыс тәжірибесін көрсету ұсынылады");}
 }
 public static final class StandardResumeChecker extends ResumeChecker{protected void checkSkills(Profile p,List<String>w){if(p.skills().isEmpty())w.add("Кемінде бір дағды қосыңыз");}}
 // US-06, US-07 — STRATEGY
 public interface VacancySortStrategy{List<Vacancy>sort(List<Vacancy>v);}
 public static final class SalaryDescendingStrategy implements VacancySortStrategy{public List<Vacancy>sort(List<Vacancy>v){List<Vacancy>r=new ArrayList<>(Objects.requireNonNull(v));r.sort(Comparator.comparingInt(Vacancy::salary).reversed());return List.copyOf(r);}}
 public static final class TitleAscendingStrategy implements VacancySortStrategy{public List<Vacancy>sort(List<Vacancy>v){List<Vacancy>r=new ArrayList<>(Objects.requireNonNull(v));r.sort(Comparator.comparing(Vacancy::title,String.CASE_INSENSITIVE_ORDER));return List.copyOf(r);}}
 public static final class VacancySorter{private VacancySortStrategy strategy;public VacancySorter(VacancySortStrategy s){setStrategy(s);}public void setStrategy(VacancySortStrategy s){strategy=Objects.requireNonNull(s);}public List<Vacancy>sort(List<Vacancy>v){return strategy.sort(v);}}
 // US-08, US-09 — ADAPTER
 public record ExternalVacancy(String positionName,String employer,String monthlySalary){}
 public interface VacancySource{Vacancy toVacancy();}
 public static final class LegacyVacancyAdapter implements VacancySource{private final ExternalVacancy external;public LegacyVacancyAdapter(ExternalVacancy e){external=Objects.requireNonNull(e);}public Vacancy toVacancy(){if(external.positionName()==null||external.employer()==null||external.monthlySalary()==null)throw new IllegalArgumentException("Сыртқы вакансия деректері толық емес");String d=external.monthlySalary().replaceAll("[^0-9]","");if(d.isBlank())throw new IllegalArgumentException("Жалақы форматы дұрыс емес");return new Vacancy(external.positionName(),external.employer(),Integer.parseInt(d));}}
 // US-10, US-11 — VISITOR
 public interface ReportElement{void accept(ReportVisitor v);}public interface ReportVisitor{void visit(Profile p);void visit(Vacancy v);}
 public static final class ProfileElement implements ReportElement{private final Profile p;public ProfileElement(Profile p){this.p=Objects.requireNonNull(p);}public Profile value(){return p;}public void accept(ReportVisitor v){v.visit(p);}}
 public static final class VacancyElement implements ReportElement{private final Vacancy v;public VacancyElement(Vacancy v){this.v=Objects.requireNonNull(v);}public Vacancy value(){return v;}public void accept(ReportVisitor x){x.visit(v);}}
 public static final class SummaryVisitor implements ReportVisitor{private final List<String>reports=new ArrayList<>();public void visit(Profile p){reports.add("Профиль: "+p.name()+"; дағдылар саны: "+p.skills().size()+"; тәжірибе: "+p.experienceYears()+" жыл");}public void visit(Vacancy v){reports.add("Вакансия: "+v.title()+"; компания: "+v.company()+"; жалақы: "+v.salary()+" ₸");}public List<String>reports(){return List.copyOf(reports);}}
 private static String requireText(String v,String f){if(v==null||v.isBlank())throw new IllegalArgumentException(f+" бос болмауы керек");return v.trim();}
}