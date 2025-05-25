package tp1.ConditionCoverageTest;

import org.example.Palindrome;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exo1Test {

    @Test(expected = NullPointerException.class)
    public void testNullInput() {
        Palindrome.isPalindrome(null);
    }

    @Test
    public void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    @Test
    public void testSingleCharacter() {
        assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test
    public void testSimplePalindrome() {
        assertTrue(Palindrome.isPalindrome("madam"));
    }

    @Test
    public void testPalindromeWithSpaces() {
        assertTrue(Palindrome.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    public void testPalindromeWithMixedCase() {
        assertTrue(Palindrome.isPalindrome("RaceCar"));
    }

    @Test
    public void testNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
    }

    @Test
    public void testNonPalindromeWithSimilarLetters() {
        assertFalse(Palindrome.isPalindrome("ab"));
    }
}
