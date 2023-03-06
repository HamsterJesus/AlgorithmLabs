package PersonalStudy;
import java.util.*;

public class PriorityQueuesMain {
    public static void main(String[] args) {
        //Priority Queues are FIFO. Serves elments with the highest priority first before ones with lower priority

        //QUEUE VS PRIORITY QUEUE

        //Queue:
        //create queue of student gpas
        Queue<Double> gpaQueue = new LinkedList<Double>();

        //add students gpas
        gpaQueue.offer(3.0);
        gpaQueue.offer(2.5);
        gpaQueue.offer(4.0);
        gpaQueue.offer(1.5);
        gpaQueue.offer(2.0);

        while(!gpaQueue.isEmpty()){ //while gpaQueue isn't empty
            System.out.println(gpaQueue.poll()); //displays and removes each students gpa
        }

        //the result is that each students gpa is displayed in first come first serve order

        System.out.println("Break"); //for my own readability

        //Priority Queue: 
        //(Doubles)
        //create priority queue of student gpas
        //Queue<Double> gpaPriorityQueue = new PriorityQueue<Double>(); //ascending
        Queue<Double> gpaPriorityQueue = new PriorityQueue<Double>(Collections.reverseOrder()); //descending

        //add students gpas
        gpaPriorityQueue.offer(3.0);
        gpaPriorityQueue.offer(2.5);
        gpaPriorityQueue.offer(4.0);
        gpaPriorityQueue.offer(1.5);
        gpaPriorityQueue.offer(2.0);

        while(!gpaPriorityQueue.isEmpty()){ //while gpaPriorityQueue isn't empty
            System.out.println(gpaPriorityQueue.poll()); //displays and removes each students gpa
        }

        //the result is that each students gpa is displayed in ascending (or descending if "Collections.reverseOrder()" is used)

        System.out.println("Break"); //for my own readability

        //(strings)
        Queue<String> gradePriorityQueue = new PriorityQueue<String>(); //descending

        //add students gpas
        gradePriorityQueue.offer("B");
        gradePriorityQueue.offer("C");
        gradePriorityQueue.offer("A");
        gradePriorityQueue.offer("F");
        gradePriorityQueue.offer("D");

        while(!gradePriorityQueue.isEmpty()){ //while gpaPriorityQueue isn't empty
            System.out.println(gradePriorityQueue.poll()); //displays and removes each students gpa
        }

        //result is that the grades are displayed in alphabetical order
    }
}
