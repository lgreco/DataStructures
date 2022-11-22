import java.util.HashMap;

public class Contacts {

    static class Person{
        String fname;
        String lname;
        String address;
        String email;
        public Person(String fname, String lname, String address, String email) {
            this.fname = fname;
            this.lname = lname;
            this.address = address;
            this.email = email;
        }
                public String toString() {
            return String.format(" [%s %s]\n", fname, lname);
        }
    }

    public static void main(String[] args) {
        HashMap<String, Person> myFriends = new HashMap();
        Person a = new Person("Saruman", "TheWise", "Orthanc", "saruman@mordor.com");
        Person b = new Person("Gandalf", "TheWrite", "Middle Earth", "gandalf@luc.edu");
        Person c = new Person("Tom", "Bombadil", "Middle Earth", "tom@luc.edu");
        Person d = new Person("Sam", "Gamgee", "Middle Earth", "tom@luc.edu");

        Person inserting;
        inserting = myFriends.putIfAbsent(a.email, a);
        System.out.println(inserting);
        inserting = myFriends.putIfAbsent(b.email, b);
        System.out.println(inserting);
        inserting = myFriends.putIfAbsent(c.email, c);
        System.out.println(inserting);
        inserting = myFriends.putIfAbsent(d.email, d);
        System.out.println(inserting);
        System.out.println();

        System.out.println(myFriends);
    }
}
