public class Individual {

    String fname, lname;

    public Individual(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public Individual(Individual another) {
        this.fname = another.fname;
        this.lname = another.lname;
    }

    public static void main(String[] args) {
        Individual leo = new Individual("Leo", "Irakliotis");
        Individual tom = new Individual(leo);
        System.out.println(tom.fname);
        tom.fname = "Tom";
        System.out.println(tom.fname);
        System.out.println(leo.fname);
    }
}
