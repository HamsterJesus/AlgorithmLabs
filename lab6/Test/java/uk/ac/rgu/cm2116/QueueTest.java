package uk.ac.rgu.cm2116;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

public class QueueTest {

    @Test
    public void testAddSuccess(){
        java.util.Queue<String> queue = new Queue<>();

        queue.add("hello");
        assertEquals(1, queue.size());

        queue.add("world");
        assertEquals(2, queue.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testAddNoSuccess(){
        java.util.Queue<String> queue = new Queue<>();
        
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");

        queue.add("f"); // this should fail
    }

    @Test
    public void testRemoveSuccessful(){
        java.util.Queue<String> queue = new Queue<>();

        String value1 = "hello";
        String value2 = "world";

        queue.add(value1);
        queue.add(value2);

        String result1 = queue.remove();
        String result2 = queue.remove();

        assertEquals(value1, result1);
        assertEquals(value2, result2);

    }

    @Test
    public void testRemoveEmptyQueue(){
        java.util.Queue<String> queue = new Queue<>();
        
        assertNull(queue.remove());
    }
    
    @Test
    public void testOfferSuccess(){
        java.util.Queue<String> queue = new Queue<>();
        boolean result = queue.offer(""); // can be an empty string
        assertTrue(result);
    }    

    @Test
    public void testOfferNoSuccess(){
        java.util.Queue<String> queue = new Queue<>();
          
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");

        boolean result = queue.offer("f"); // this should fail
        assertFalse(result);
    }

    @Test
    public void testIsEmpty(){
        java.util.Queue<String> queue = new Queue<>();
        assertTrue(queue.isEmpty());

        queue.add("");
        assertFalse(queue.isEmpty());

        queue.remove();
        assertTrue(queue.isEmpty());
    }

}
