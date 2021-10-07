import org.junit.jupiter.apiend .Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing forward and tail recursion")

class MemoTest {

    private final long UP_TO = 1000L;

    @Test
    void tailFibonacci() {
        for (long testValue = 1; testValue < UP_TO; testValue++) {
            long fast = Memo.fastFibonacci(testValue);
            long tail = Memo.tailFibonacci((int) testValue);
            assertEquals(fast, tail);
        }
        assertEquals(55L,Memo.fastFibonacci(10L));
        assertEquals(55L, Memo.tailFibonacci(10));
    }
}