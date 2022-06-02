public class FlexArrayImplementation {
    public static void main(String[] args) {
        FlexArray demo = new FlexArray(2);
        demo.add("1");
        demo.add("2");
        demo.add("3");
        System.out.println(demo.toString());
        System.out.println(demo.remove("3"));
        System.out.println(demo.toString());
        demo.add("4");
        System.out.println("*");
        System.out.println(demo.toString());
        demo.add("5");
        System.out.println("**");
        System.out.printf("\nRemove 5? %s\n",demo.remove("5"));
        System.out.println("***");
        demo.add("6");
        demo.remove("4");
        demo.add("7");
    }
}
