package TESTS;
import org.junit.Test;
import src.StackWithVector;
import static org.junit.Assert.*;

public class StackWithVectorsTests {

    @Test
    public void testConstructor() {
        StackWithVector<Integer> stack = new StackWithVector<>(10);
        assertNotNull(stack);
        assertEquals(0, stack.count());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushAndPop() {
        StackWithVector<Integer> stack = new StackWithVector<>(10);
        stack.push(5);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.count());
        assertEquals(Integer.valueOf(5), stack.peek());
        
        Integer poppedValue = stack.pop();
        assertEquals(0, stack.count());
        assertTrue(stack.isEmpty());
        assertEquals(Integer.valueOf(5), poppedValue);
    }

    @Test
    public void testPushAndPeek() {
        StackWithVector<Integer> stack = new StackWithVector<>(10);
        stack.push(5);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.count());
        assertEquals(Integer.valueOf(5), stack.peek());
        
        assertEquals(1, stack.count()); // Count should remain the same after peek
        assertFalse(stack.isEmpty()); // Stack should not be empty after peek
    }

    @Test
    public void testMultiplePushAndPop() {
        StackWithVector<Integer> stack = new StackWithVector<>(10);
        stack.push(5);
        stack.push(10);
        stack.push(15);
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.count());

        assertEquals(Integer.valueOf(15), stack.pop());
        assertEquals(2, stack.count());

        assertEquals(Integer.valueOf(10), stack.pop());
        assertEquals(1, stack.count());

        assertEquals(Integer.valueOf(5), stack.pop());
        assertEquals(0, stack.count());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopOnEmptyStack() {
        StackWithVector<Integer> stack = new StackWithVector<>(10);
        assertNull(stack.pop());
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.count());
    }

    @Test
    public void testPeekOnEmptyStack() {
        StackWithVector<Integer> stack = new StackWithVector<>(10);
        assertNull(stack.peek());
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.count());
    }
}
