public class ImplementPersons {

    public static void main(String[] args) {

        Person zach = new Person("Zach");
        System.out.println(zach.toString());

        zach.setFavoriteFood("steak");
        zach.setRestLength(9);

        System.out.println(zach.toString());

        Person chloe = new Person("Chloe", "pizza", 10);
        System.out.println(chloe.toString());

    }
}
