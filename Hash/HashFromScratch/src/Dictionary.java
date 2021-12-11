public class Dictionary {

    private static final int DEFAULT_SIZE = 10;
    private static final double MAX_LOAD_FACTOR = 0.75;

    private String[] keys;
    private String[] values;
    private int load;

    public Dictionary(){
        this.keys = new String[DEFAULT_SIZE];
        this.values = new String[DEFAULT_SIZE];
        this.load = 0;
    }

    private double loadFactor() {
        return ((double) this.load) / ((double) this.keys.length);
    }

    private int hashFunction(String key) {
        int charSum = 0;
        for (int i = 0; i < key.length(); i++)
            charSum += (int) key.charAt(i);
        return charSum % this.keys.length;
    }


}
