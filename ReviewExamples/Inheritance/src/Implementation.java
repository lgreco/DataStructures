import java.time.temporal.TemporalAccessor;

public class Implementation {
    public static void main(String[] args) {

        Person mySchool[] = new Person[5];

        mySchool[0] = new Person("Leo");
        mySchool[1] = new Person("Kristin");
        mySchool[2] = new Person("Sarah");
        mySchool[3] = new Person("Drake");
        mySchool[4] = new Person("Dana");

        for (Person p:mySchool) {
            System.out.println(p.toString());
        }

        Student s = new Student("Leo", 2022);
        Person p = (Person) s;
        Professor f = null;
    }
}
