public class Implementation {
    public static void main(String[] args) {
        FileCabinet ourSchool = new FileCabinet(4);
        ourSchool.addStudentRecord("Frodo", "Baggins", "Metallurgy");
        System.out.println(ourSchool.contains("Frodo", "Baggins"));
        System.out.println(ourSchool.contains("Leo", "Irakliotis"));
        ourSchool.addStudentRecord("Leo", "Irakliotis", "Physics");
        System.out.println(ourSchool.contains("Leo", "Irakliotis"));
    }
}
