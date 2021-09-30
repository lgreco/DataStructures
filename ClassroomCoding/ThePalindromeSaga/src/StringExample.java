public class StringExample {
    public static void main(String[] args) {
        EnchantedArray ourSecondMagicArray = new EnchantedArray(2);
        ourSecondMagicArray.add("This");
        ourSecondMagicArray.add("is");
        ourSecondMagicArray.add("awesome");

        ourSecondMagicArray.inUse = 10;

        System.out.println(ourSecondMagicArray.getContents(7));
    }
}
