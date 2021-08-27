import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {

    @Test
    static void isPalindrome() {

        assertTrue(Palindrome.isPalindrome("A"));
        assertTrue(Palindrome.isPalindrome("Noon"));
        assertTrue(Palindrome.isPalindrome("Race Car"));
        assertTrue(Palindrome.isPalindrome("A man, a plan, a canal: Panama!"));
/*
        assertFalse(Palindrome.isPalindrome("5"));
        assertFalse(Palindrome.isPalindrome(""));
        assertFalse(Palindrome.isPalindrome("55AA55")); */
    }

    public static void main(String[] args) {
        isPalindrome();
    }
}