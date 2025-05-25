package tp1.BranchCoverageTest;

import org.example.Anagram;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exo2Test {
    @Test
    public void testDifferentLengthStrings() {
        assertFalse(Anagram.isAnagram("abc", "ab"));
    }

    @Test
    public void testAnagramWithDifferentCase() {
        assertTrue(Anagram.isAnagram("Listen", "Silent"));
    }

    @Test
    public void testAnagramWithSpaces() {
        assertTrue(Anagram.isAnagram("the eyes", "they see"));
    }

    @Test
    public void testNonAnagramSameLength() {
        assertFalse(Anagram.isAnagram("abc", "def"));
    }

    @Test
    public void testAlmostAnagramOneCharDifference() {
        assertFalse(Anagram.isAnagram("abc", "abd"));
    }
}