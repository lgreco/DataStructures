public class Implementation {
    public static void main(String[] args) {
        FileCabinet ourSchool = new FileCabinet(4);
        ourSchool.addStudentRecord("Frodo", "Baggins", "Metallurgy");
        ourSchool.addStudentRecord("Leo", "Irakliotis", "Physics");
        ourSchool.addStudentRecord("Saruman","White", "Political Science");
        ourSchool.addStudentRecord("Gandalf", "Grey", "History");
        ourSchool.addStudentRecord("Tom", "Bombadil", "Cosmology");
        ourSchool.addStudentRecord("James", "Kirk", "Theater");
        ourSchool.addStudentRecord("Hans", "Solo", "Aeronautics");


        ourSchool.printContents();
        ourSchool.showHashes();
    }
}
