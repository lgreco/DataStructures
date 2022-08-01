public class TestPostalCodes  {

    private static int count(int zipCode, PostalCodes postalCodes) {
        int counter = 0;
        Zip[] codes = postalCodes.getCodes();
        if (codes[zipCode%codes.length] != null) {
            Zip current = codes[zipCode%codes.length];
            while (current != null) {
                if (current.getZipCode() == zipCode)
                    counter++;
                current = current.getNext();
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        PostalCodes demo = new PostalCodes(4);
        demo.put(60601, "Chicago");
        demo.put(60601, "Chicago");
        if (count(60601,demo) > 1)
            System.out.println("\nTest failed: your structure allows duplicate zip codes.");
        else if (count(60601, demo) == 1)
            System.out.println("\nTest passes: your structure seems to be working as specified");
        else
            System.out.println("\nTest failed: your structure doesn't accept unique keys.");
    }

}
