package tp1.LineCoverageTest;


import org.example.Anagram;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exo2Test {

    // ========== Line Coverage Tests ==========

    @Test(expected = NullPointerException.class)
    public void testFirstStringNull() {
        Anagram.isAnagram(null, "test");
    }

    @Test(expected = NullPointerException.class)
    public void testSecondStringNull() {
        Anagram.isAnagram("test", null);
    }

    @Test
    public void testEmptyStrings() {
        assertTrue(Anagram.isAnagram("", ""));
    }

    @Test
    public void testSingleCharacterAnagram() {
        assertTrue(Anagram.isAnagram("a", "a"));
    }
}