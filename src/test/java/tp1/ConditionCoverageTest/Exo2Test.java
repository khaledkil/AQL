package tp1.ConditionCoverageTest;

import org.example.Anagram;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exo2Test {
    @Test
    public void testComplexAnagram() {
        assertTrue(Anagram.isAnagram("debit card", "bad credit"));
    }

    @Test
    public void testNonAnagramWithSameLettersDifferentCounts() {
        assertFalse(Anagram.isAnagram("aab", "abb"));
    }

    @Test
    public void testAllLettersDifferent() {
        assertFalse(Anagram.isAnagram("abc", "xyz"));
    }

    @Test
    public void testAnagramWithRepeatedLetters() {
        assertTrue(Anagram.isAnagram("aabbcc", "abcabc"));
    }
}
