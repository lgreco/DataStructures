public class TestPostalCodes {

    public static void main(String[] args) {
        PostalCodes demo = new PostalCodes(5);
        System.out.println(demo);
        demo.put(60601, "Chicago");
        demo.put(60605, "Chicago");
        demo.put(60602, "Oak Park");
        demo.put(60602, "Oak Park");
        demo.put(62704, "Springfield");
        demo.put(60156, "Lake in the Hills");
        demo.put(54648, "Washington");
        demo.put(60601, "New York");
        System.out.println(demo);
    }

}
