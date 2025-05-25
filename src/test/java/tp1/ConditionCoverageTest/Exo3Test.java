package tp1.ConditionCoverageTest;
import org.example.BinarySearch;
import org.junit.Test;
import static org.junit.Assert.*;
public class Exo3Test {
    @Test
    public void testEvenLengthArrayElementFound() {
        assertEquals(3, BinarySearch.binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 4));
    }

    @Test
    public void testOddLengthArrayElementFound() {
        assertEquals(2, BinarySearch.binarySearch(new int[]{1, 2, 3, 4, 5}, 3));
    }

    @Test
    public void testDuplicateElements() {
        assertEquals(2, BinarySearch.binarySearch(new int[]{1, 2, 3, 3, 4, 5}, 3));
    }

    @Test
    public void testAllElementsSameFound() {
        assertEquals(2, BinarySearch.binarySearch(new int[]{5, 5, 5, 5, 5}, 5));
    }

    @Test
    public void testAllElementsSameNotFound() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{5, 5, 5, 5, 5}, 3));
    }

    @Test
    public void testLargeArray() {
        int[] largeArray = new int[1000];
        for (int i = 0; i < 1000; i++) {
            largeArray[i] = i;
        }
        assertEquals(500, BinarySearch.binarySearch(largeArray, 500));
    }
}

