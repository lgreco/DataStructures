public class Person implements Measurement<Person>, Comparable<Person> {

    private String name;
    private int heightInches;
    private int age;

    @Override
    public boolean isTaller(Person p) {
        return this.heightInches > p.heightInches;
    }

    /**
     * leo.compareTo(joseph):
     *
     * @param p
     * @return
     */
    public int compareTo(Person p) {
        int diff = this.age - p.age;
        int result = 0;
        if (diff > 0)
            result = 1;
        if (diff < 0)
            result = -1;
        return result;
    }


}
