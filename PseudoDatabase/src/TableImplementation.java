public class TableImplementation {
    private static final int DEFAULT_CAPACITY = 10;
    Table<String, String>[] students = new Table[DEFAULT_CAPACITY];
    Table<String,String>[] courses = new Table[DEFAULT_CAPACITY];

    private void test() {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                System.out.println("Object is empty");
            } else {
                System.out.println("Object is not empty");
            }
        }
    }

    public static void main(String[] args) {
        TableImplementation demo = new TableImplementation();
        demo.test();
    }

}
