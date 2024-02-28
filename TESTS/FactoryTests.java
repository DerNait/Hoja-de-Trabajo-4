package TESTS;
import org.junit.Test;
import src.IStack;
import src.StackFactory;
import src.StackWithArray;
import src.StackWithDoubleList;
import src.StackWithSingleList;
import src.StackWithVector;
import static org.junit.Assert.*;

public class FactoryTests {

    @Test
    public void testGetStackInstance() {
        // Test for STACK_WITH_ARRAY
        IStack<Integer> stackWithArray = StackFactory.getStackInstance(StackFactory.STACK_WITH_ARRAY);
        assertNotNull("StackWithArray instance should not be null", stackWithArray);
        assertTrue("StackWithArray instance should be of type StackWithArray", stackWithArray instanceof StackWithArray);
        
        // Test for STACK_WITH_VECTOR
        IStack<Integer> stackWithVector = StackFactory.getStackInstance(StackFactory.STACK_WITH_VECTOR);
        assertNotNull("StackWithVector instance should not be null", stackWithVector);
        assertTrue("StackWithVector instance should be of type StackWithVector", stackWithVector instanceof StackWithVector);
        
        // Test for STACK_WITH_SINGLE_LIST
        IStack<Integer> stackWithSingleList = StackFactory.getStackInstance(StackFactory.STACK_WITH_SINGLE_LIST);
        assertNotNull("StackWithSingleList instance should not be null", stackWithSingleList);
        assertTrue("StackWithSingleList instance should be of type StackWithSingleList", stackWithSingleList instanceof StackWithSingleList);
        
        // Test for STACK_WITH_DOUBLE_LIST
        IStack<Integer> stackWithDoubleList = StackFactory.getStackInstance(StackFactory.STACK_WITH_DOUBLE_LIST);
        assertNotNull("StackWithDoubleList instance should not be null", stackWithDoubleList);
        assertTrue("StackWithDoubleList instance should be of type StackWithDoubleList", stackWithDoubleList instanceof StackWithDoubleList);
        
        // Test for default case (STACK_WITH_ARRAY)
        IStack<Integer> defaultStack = StackFactory.getStackInstance(100); // Any integer not matching any defined type
        assertNotNull("Default stack instance should not be null", defaultStack);
        assertTrue("Default stack instance should be of type StackWithArray", defaultStack instanceof StackWithArray);
    }
}