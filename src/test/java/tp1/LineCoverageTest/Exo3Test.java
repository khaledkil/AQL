package tp1.LineCoverageTest;
import org.example.BinarySearch;
import org.junit.Test;
import static org.junit.Assert.*;
public class Exo3Test {
    @Test(expected = NullPointerException.class)
    public void testNullArray() {
        BinarySearch.binarySearch(null, 5);
    }

    @Test
    public void testEmptyArray() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{}, 5));
    }

    @Test
    public void testSingleElementArrayFound() {
        assertEquals(0, BinarySearch.binarySearch(new int[]{5}, 5));
    }
}
