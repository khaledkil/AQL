package tp1.LineCoverageTest;
import org.example.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Exo1Test {
    @Test
    void testNullInput() {
        // Couvre la ligne qui lance une exception si la chaîne est null
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    @Test
    void testPalindromeAvecBoucle() {
        // Couvre la normalisation, la boucle while, le if à l'intérieur, et le return true
        assertTrue(Palindrome.isPalindrome("kayak"));
    }

    @Test
    void testNonPalindromePourReturnFalse() {
        // Couvre le cas où la chaîne n'est pas un palindrome (return false)
        assertFalse(Palindrome.isPalindrome("test"));
    }
}
