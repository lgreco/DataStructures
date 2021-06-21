public class Professor extends Person {

    private String department;

    public Professor(String name, String department) {
        super(name);
        this.department = department;
    }

    @Override
    public String toString() {
        return super.getName() + " is a member of the " + department + " faculty.";
    }
}
