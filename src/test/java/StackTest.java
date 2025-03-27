import org.example.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testPushAndPop() {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    void testPeek() {
        Stack stack = new Stack();
        stack.push(5);
        assertEquals(5, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void testIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
        stack.push(42);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testPopFromEmptyStack() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    void testPeekFromEmptyStack() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }

}
