package tp1.BranchCoverageTest;
import org.example.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Exo1Test {
    @Test
    void testNullInput() {
        // Branche 1: Couvre la condition "if (s == null)" -> true
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    @Test
    void testPalindrome() {
        // Branche 2: Couvre la boucle "while (i < j)" avec une chaîne palindrome
        assertTrue(Palindrome.isPalindrome("kayak"));
    }

    @Test
    void testNonPalindrome() {
        // Branche 3: Couvre le cas où la chaîne n'est pas un palindrome (if à l'intérieur de la boucle)
        assertFalse(Palindrome.isPalindrome("test"));
    }

    @Test
    void testEmptyString() {
        // Branche 4: Couvre la chaîne vide (condition "while (i < j)" ne s'exécute pas)
        assertTrue(Palindrome.isPalindrome(""));
    }

    @Test
    void testSingleCharacter() {
        // Branche 5: Couvre une seule lettre (le "while" ne s'exécute pas)
        assertTrue(Palindrome.isPalindrome("A"));
    }
}
