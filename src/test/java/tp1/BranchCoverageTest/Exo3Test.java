package tp1.BranchCoverageTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.example.BinarySearch;

public class Exo3Test {
    @Test
    public void testSingleElementArrayNotFound() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{3}, 5));
    }

    @Test
    public void testElementFoundAtFirstPosition() {
        assertEquals(0, BinarySearch.binarySearch(new int[]{1, 2, 3, 4, 5}, 1));
    }

    @Test
    public void testElementFoundAtLastPosition() {
        assertEquals(4, BinarySearch.binarySearch(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    public void testElementFoundAtMiddlePosition() {
        assertEquals(2, BinarySearch.binarySearch(new int[]{1, 2, 3, 4, 5}, 3));
    }

    @Test
    public void testElementNotFound() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{1, 2, 4, 5}, 3));
    }

    @Test
    public void testElementSmallerThanAll() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{2, 3, 4, 5}, 1));
    }

    @Test
    public void testElementLargerThanAll() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{1, 2, 3, 4}, 5));
    }
}
