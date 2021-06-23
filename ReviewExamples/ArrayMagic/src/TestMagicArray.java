public class TestMagicArray {

    public static void main(String[] args) {
        MagicArrays test = new MagicArrays();
        test.addElement("Frodo");
        test.addElement("Sam");
        test.addElement("Galadriel");
        test.addElement("Gimli");
        test.addElement("Eowen");
        test.addElement("Faramir");
        test.addElement("Boromir");
        test.addElement("Pipin");
        test.addElement("Leo");
        test.addElement("Tom");
        test.addElement("Gandalf");
        test.addElement("Legolas");
        test.addElement("Bilbo");
        test.addElement("Denethor");
        test.addElement("Elrond");
        test.addElement("Saruman");
        test.addElement("Smegol",4);
        test.printMagicArray();

        System.out.printf("\n\nArray contains Elrond: %b", test.contains("Elrond"));
        System.out.printf("\n\nArray contains Thomas: %b", test.contains("Thomas"));

        System.out.printf("\n\nElement at position 4 removed? %b", test.removeElement(4)); // Eowen
        System.out.printf("\n\nElement Bilbo removed? %b", test.removeElement("Bilbo"));
        System.out.printf("\n\nElement Irakliotis removed? %b\n\n",test.removeElement("Irakliotis"));

        test.printMagicArray();
    }
}
