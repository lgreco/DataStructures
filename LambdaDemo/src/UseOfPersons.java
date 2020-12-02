import java.util.List;

public class UseOfPersons {

    static void printSelection(List<Person> roster, CheckPerson testingCriterion) {
        for (Person p: roster) {
            if (testingCriterion.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void main(String[] args) {
        List<Person> demoRoster = Person.createRoster();
        for (Person p: demoRoster) {
            p.printPerson();
        }
        System.out.println();

        // people over 31
        System.out.println("Over 31:");
        printSelection(demoRoster, (Person p) -> p.getAge()>31);
        System.out.println();

        // people between 31 and 85
        System.out.println("Between 31 and 85:");
        printSelection(demoRoster, (Person p) -> 31 < p.getAge() && p.getAge() < 85 );
        System.out.println();

        // US President
        System.out.println("US president:");
        printSelection(demoRoster, (Person p) -> p.getAge() > 31 && p.getCountryOfBirth().equals("USA"));
        System.out.println();

        // Leo for US President
        System.out.println("Leo for president:");
        printSelection(demoRoster, (p) -> p.getName().length()==3);
        System.out.println();
    }
}