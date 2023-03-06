package PersonalStudy;
import java.util.Stack; //import stack data type

public class StacksMain {
    
    public static void main(String[] args) {

        //Stacks a LIFO data structure A
        //Acts sort of like a tower of books, you can't get to the book at the bottom without removing the ones on top of it
        
        //create stack
        Stack<String> VideoGameStack = new Stack<String>();

        //EMPTY:
        //.empty() checks if stack is empty and returns true or false
        //System.out.println(stack.empty()); TRUE

        //populate stack
        VideoGameStack.push("Sims 3");
        VideoGameStack.push("Overwatch 2");
        VideoGameStack.push("It takes two");
        VideoGameStack.push("Dead by Daylight");
        VideoGameStack.push("SCP:SL");

        //System.out.println(stack.empty()); FALSE

        //POP:
        //VideoGameStack.pop(); //removes SCP:SL (pop always removes that last added item from the stack)
        //VideoGameStack.pop(); //removes DBD //You can keep doing this so until the stack is empty, but if you continue it will throw an exception
        //String bestGame = VideoGameStack.pop(); //pop also returns the object so you can assign a popped object to variable and still have it be removed from the stack
        //System.out.println(bestGame);

        //PEEK: 
        //System.out.println(VideoGameStack.peek()); //peek allows you to access what is at the top of the stack without removing it

        //SEARCH:
        //System.out.println(VideoGameStack.search("Sims 3")); //Search returns the position of the object in the stack (Note: First item in the stack would be 1 and not 0, so this returns 5)
        //System.out.println(VideoGameStack.search("Mario Kart")); //If you search for an item that is not in the stack it will return -1

        System.out.println(VideoGameStack);

        //Uses of stacks?
        //Undo and Redo features in text editors
        //Moving back and forward through browser history
        //backtracking algorithms (e.g navigating file directories)
        // calling functions
    }
}
