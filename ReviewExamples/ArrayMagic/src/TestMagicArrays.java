/**
 * Testing class for the Magic Arrays assignment. The class contains just a main
 * method that instantiates MagicArrays as object named "test". The object is
 * populated with elements. Then we conduct two tests of the contains()
 * method. And then we conducted three tests of the removeElement() method.
 */
public class TestMagicArrays {

    public static void main(String[] args) {
        // Instantiate test object
        MagicArrays test = new MagicArrays();
        // Populate test object
        test.addElement("Frodo"); test.addElement("Sam"); test.addElement("Galadriel");
        test.addElement("Gimli"); test.addElement("Eowyn"); test.addElement("Faramir");
        test.addElement("Boromir"); test.addElement("Pipin"); test.addElement("Leo");
        test.addElement("Tom"); test.addElement("Gandalf"); test.addElement("Legolas");
        test.addElement("Bilbo"); test.addElement("Denethor"); test.addElement("Elrond");
        test.addElement("Saruman"); test.addElement("Smeagol",4);

        test.printMagicArray();

        // Test the contains() method
        System.out.printf("\n\nArray contains Elrond: %b", test.contains("Elrond"));
        System.out.printf("\n\nArray contains Thomas: %b", test.contains("Thomas"));

        // Test the removeElement() method
        System.out.printf("\n\nElement at position 4 removed? %b", test.removeElement(4)); // Eowyn
        System.out.printf("\n\nElement Bilbo removed? %b", test.removeElement("Bilbo"));
        System.out.printf("\n\nElement Irakliotis removed? %b\n\n",test.removeElement("Irakliotis"));

        // Visually verify removals
        test.printMagicArray();
    }
}
