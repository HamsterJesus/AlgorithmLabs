package PersonalStudy;
import java.util.*;

public class LinkedListsMain {
    public static void main(String[] args) {
        //Linked lists: store nodes in 2 parts (data and address)
        //Singly linked = (data + next address)
        //Doubly linked = previous address + data + next address)
        
        //Treated as STACK: (refer to "StacksMain.java")
        //create linked list
        LinkedList<String> linkedListStack = new LinkedList<String>();

        //populate linked list
        linkedListStack.push("A");
        linkedListStack.push("B");
        linkedListStack.push("C");
        linkedListStack.push("D");
        linkedListStack.push("F");
        //linkedListStack.pop();

        //display result of linkedList
        //System.out.println(linkedListStack);

        //----------------------------------------------------
        //System.out.println("break");
        //----------------------------------------------------

        //Treated as QUEUE: (refer to QueuesMain.java)
        //create linked list
        LinkedList<String> linkedListQueue = new LinkedList<String>();

        linkedListQueue.offer("A");
        linkedListQueue.offer("B");
        linkedListQueue.offer("C");
        linkedListQueue.offer("D");
        linkedListQueue.offer("F");
        //linkedListQueue.poll();

        //ADD:
        linkedListQueue.add(4, "E"); //Inserts value between D and F, taking in index and the value to be inserted

        //REMOVE:
        linkedListQueue.remove("B"); //removes an element for the list

        //SEARCHING
        System.out.println(linkedListQueue.indexOf("F")); //returns the index of the element we are searching for

        //PEEK
        System.out.println(linkedListQueue.peekFirst()); //returns element at head of list
        System.out.println(linkedListQueue.peekLast()); //returns element at tail of list

        //ADDING TO FIRST OR LAST
        linkedListQueue.addFirst("Alphabet"); //add new element to head
        linkedListQueue.addLast("G"); //add new element to tail

        //REMOVING FIRST OR LAST
        String first = linkedListQueue.removeFirst(); //remove element at head of list
        String last = linkedListQueue.removeLast(); //remove lement at tail of list

        System.out.println(linkedListQueue + " "  + first + " "  + last);

        //Uses of LinkedList?
        //implement stacks/queues
        //music  playlists

    }
}
