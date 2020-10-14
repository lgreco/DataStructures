import java.util.Random;

public class TestHash {

    public boolean remove_slow(int value) {
        boolean success = false;
        if (contains(value)) {
            int index = 0;
            while ( index < size ) {
                if (setElements[index] == value) {
                    for ( int i = index; i < size-1; i++ ) {
                        setElements[i] = setElements[i+1];
                    }
                    index = size+1; // escape clause for the while loop
                    size--;
                    success = true;
                } else {
                    index++;
                }
            }
        }
        return success;
    }

    public boolean remove_fast(int value) {
        boolean success = false;
        if (contains(value)) {
            int index = 0;
            while (index < size) {
                if (setElements[index] == value) {
                    setElements[index] = setElements[size-1];
                    index = size+1; // escape from while loop
                    size--;
                    success = true;
                } else {
                    index++;
                }
            }
        }
        return success;
    }

    public void test_Fast_Slow() {
        ArrayIntegerSet test_slow = new ArrayIntegerSet();
        ArrayIntegerSet test_fast = new ArrayIntegerSet();
        // populate to 80% capacity
        int len = test_slow.setElements.length;
        int eightyPerCent = (int) 0.8*len;
        Random r = new Random();
        for (int i=0; i < eightyPerCent; i++) {
            test_slow.setElements[i] = r.nextInt(len);
            test_fast.setElements[i] = test_slow.setElements[i];
        }
    }

}
