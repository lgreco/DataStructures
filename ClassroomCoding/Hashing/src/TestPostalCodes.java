public class TestPostalCodes  {

    private static int count(int zipCode, PostalCodes postalCodes) {
        int counter = 0;
        for (Zip zip:
                postalCodes.getCodes()) {
            if (zip != null) {
                Zip cursor = zip;
                while (cursor != null) {
                    if (cursor.getZipCode() == zipCode)
                        counter++;
                    cursor = cursor.getNext();
                }
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
