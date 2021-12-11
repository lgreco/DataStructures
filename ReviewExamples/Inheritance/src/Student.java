package ReviewExamples.Inheritance.src;

public class Student extends Person {

    private int classOf;

    public Student(String name, int classOf) {
        super(name);
        this.classOf = classOf;
    }

    /**
     * 
     */
    public void showName(){
        // does SOMEthing
        System.out.println(this.getName());
    }

    public void setClassOf(int classOf) {
        this.classOf = classOf;
    }

    @Override
    public String toString() {
        return super.getName() + " is a member of the class of " + classOf + ".";
    }
}
