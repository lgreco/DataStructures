public class EnchantedArray {

    /** Underlying array of the class */
    private String[] a;

    /** How many elements are occupied */
    public int inUse;

    /** Default constructor */
    public EnchantedArray() {
        a = new String[10];
        inUse = 0;
    }

    /** Parameterized constructor */
    public EnchantedArray(int numberOfElements) {
        a = new String[numberOfElements];
        inUse = 0;
    }

    /**
     * Method to add data to array a.
     *
     * @return
     */
    void add(String string) {
        if (inUse < a.length) {
            // there is room for one more entry
            // Where would the new entry go? Which position in a[]?
            a[inUse] = string;
            inUse++;
        } else {
            // array a is full; need to make room
            // Create a temp array larger than a[]
            String[] temporaryArray = new String[a.length + 1];
            // Copy everything from a to the temp array
            for (int i = 0; i < a.length; i++) {
                temporaryArray[i] = a[i];
            }
            // Add new entry to temp
            temporaryArray[inUse] = string;
            inUse++;
            // Copy temp to a
            a = temporaryArray;
        }
    }


    /**
     * Method that returns the contents of the Enchanted array at specified position
     */
    String getContents(int position) {
        String content = null;
        if (position < inUse) {
            content = a[position];
        }
        return content;
    }

    /**
     * Method that tells if a string is present in array
     * @param string String we are searchign for
     * @return true if string present in a[]; false otherwise
     */
    boolean contains(String string) {
        boolean result = false;
        for (int i = 0; i < inUse; i++) {
            if (a[i].equals(string)) {
                result = true;
            }
        }
        return result;
    }

    // ADD UNIQUE
    void addUnique(String string) {
        if (! contains(string)) {
            // add it
            add(string);
        }
    }



    public int getInUse() {
        return inUse;
    }

    public static void main(String[] args) {
        EnchantedArray ourFirstDynamicArray = new EnchantedArray(2);
        ourFirstDynamicArray.add("Data");
        ourFirstDynamicArray.add("Structures");
        ourFirstDynamicArray.add("are");
        ourFirstDynamicArray.add("cool!");

    }

}
