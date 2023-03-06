package uk.ac.rgu.cm2116;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.ac.rgu.cm2116.AbstractStack.StackOverflowException;
import uk.ac.rgu.cm2116.AbstractStack.StackUnderFlowException;

public class StackTest {

    @Test
    public void testPush() throws StackOverflowException{

        Stack<String> stack = new Stack<>();

        stack.push("hello");

        assertEquals(1, stack.size());

    }

    @Test(expected=StackUnderFlowException.class)
    public void testPopEmpyStack() throws StackUnderFlowException{
        Stack<String> stack = new Stack<>();
        stack.pop(); // this should throw a StackUnderFlowException, caught by the 'expected' property
    }

    @Test
    public void testPopNotEmptyStack() throws StackUnderFlowException, StackOverflowException{
        Stack<String> stack = new Stack<>();

        stack.push("hello");
        String testElement = "world";
        stack.push(testElement);

        int size = stack.size();

        String result = stack.pop();

        /* Test that the popped element is the same as the test element */
        assertEquals(testElement, result);

        /* Test that the stack size has reduced by 1 */
        assertEquals(size - 1, stack.size());
    }

    @Test(expected=StackUnderFlowException.class)
    public void testPeekEmptyStack() throws StackUnderFlowException{
        Stack<String> stack = new Stack<>();
        stack.peek(); // this should throw a StackUnderFlowException, caught by the 'expected' property
    }

    @Test
    public void testPeekNotEmptyStack() throws StackUnderFlowException, StackOverflowException{
        Stack<String> stack = new Stack<>();

        stack.push("hello");
        String testElement = "world";
        stack.push(testElement);

        int size = stack.size();

        String result = stack.peek();

        /* Test that the peeked element is the same as the test element */
        assertEquals(testElement, result);

        /* Test that the stack size has remained the same */
        assertEquals(size, stack.size());
    }


    
}
