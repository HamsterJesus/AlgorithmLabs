package PersonalStudy;
import java.util.Queue;
import java.util.LinkedList;

public class QueuesMain {
    public static void main(String[] args) {
        //What ever is first in the queue gets prossed first
        //Think like a line at a supermarket

        //Queue<String> supermarketQueue = new Queue<String>(); //doesn't work as queue is an interface NOT a class
        //The queue interface extends the collection class (inherits from collection)

        //There are 2 classes in java that implement Queues LinkedList and PriorityQueue
        Queue<String> supermarketQueue = new LinkedList<String>();

        //OFFER: (enqueue)
        //We use offer() to add elements to our queue
        supermarketQueue.offer("Karen"); 
        supermarketQueue.offer("Chad"); 
        supermarketQueue.offer("Steve"); 
        supermarketQueue.offer("Harold"); 


        //PEEK:
        //We use peek() to view the element at the head(front) of the queue
        //System.out.println(supermarketQueue.peek());

        //POLL: (dequeue)
        //removes the head element from the queue FIFO, much the same as pop() does to stacks
        //unlike pop tho if you use poll() even if the queue is empty it will not result in an exception
        //supermarketQueue.poll();

        System.out.println(supermarketQueue);

        //COLLECTION METHODS (additional):
        //System.out.println(supermarketQueue.isEmpty()); //checks if queue is empty (boolean)
        //System.out.println(supermarketQueue.size()); //checks length of queue
        //System.out.println(supermarketQueue.contains("Harold")); //checks if item is in queue (boolean)

        //Where are queues useful?
        //Keyboard buffer (letters appear on screen in the order they are pressed)
        //printer queue (Print jobs should be completed in order)
        // Used in LinkedLists, PriorityQueues, Breadth-first search
    }
}
