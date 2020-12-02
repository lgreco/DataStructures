import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class Person {

    public enum Gender {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Gender gender;
    String emailAddress;
    String countryOfBirth;

    public Person(String name,
                  LocalDate birthday,
                  Gender gender,
                  String emailAddress,
                  String countryOfBirth) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.countryOfBirth = countryOfBirth;
    }

    public int getAge() {
        return birthday.until(IsoChronology.INSTANCE.dateNow()).getYears();
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public static List<Person> createRoster() {

        List<Person> roster = new ArrayList<>();

        roster.add(new Person("Leo", IsoChronology.INSTANCE.date(1967, 6, 29), Gender.MALE, "lirakliotis@luc.edu", "Greece"));
        roster.add(new Person("Frodo", IsoChronology.INSTANCE.date(1211, 11, 18), Gender.MALE, "frondo@shire.middle.earth", "Hobbiton"));
        roster.add(new Person("Joe", IsoChronology.INSTANCE.date(1948, 11, 18), Gender.MALE, "joe@joe.com", "USA"));
        roster.add(new Person("Jane", IsoChronology.INSTANCE.date(1965, 2, 2), Gender.FEMALE, "jane@jane.com", "USA"));
        roster.add(new Person("Tina", IsoChronology.INSTANCE.date(1999,1,1), Gender.FEMALE, "tina@tina.com","USA"));
        roster.add(new Person("Oliver", IsoChronology.INSTANCE.date(2016,2,3), Gender.MALE, "oliver@oliver.com", "USA" ));

        return roster;
    }

    public void printPerson() {
        System.out.println(name);
    }
}
