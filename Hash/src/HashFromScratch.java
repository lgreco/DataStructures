public class HashFromScratch {

    private static final int DEFAULT_CAPACITY = 10;

    HashEntry[] hashMap = new HashEntry[DEFAULT_CAPACITY];
    int size = 0;

    class HashEntry{
        private int data;
        private HashEntry next;
        public HashEntry(int data) {
            this.data = data;
            this.next = null;
        }
        public HashEntry(int data, HashEntry next) {
            this.data = data;
            this.next = next;
        }
    }

    private int hashFunction(int value) {
        return Math.abs(value) % hashMap.length;
    }

    public boolean contains(int value) {
        boolean found = false;
        int bucket = hashFunction(value);
        HashEntry current = hashMap[bucket];
        while (current != null) {
            if (current.data == value) {
                found = true;
            }
            current = current.next;
        }
        return found;
    }

    public void insert(int value) {
        if (!contains(value)) {
            int bucket = hashFunction(value);
            hashMap[bucket] = new HashEntry(value, hashMap[bucket]);
            size++;
        }
    }

    public void displayHash() {
        for (int i = 0; i < hashMap.length; i++) {
            System.out.printf("\nList for element at [%d]:", i);
            if (hashMap[i] == null) {
                System.out.printf("EMPTY!");
            } else {
                HashEntry current = hashMap[i];
                while (current != null) {
                    System.out.printf("[%d] ", current.data);
                    current = current.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        HashFromScratch demo = new HashFromScratch();
        for (int i = 1; i <=10; i++) {
            demo.insert(i*5);
        }
        demo.displayHash();

    }
}
