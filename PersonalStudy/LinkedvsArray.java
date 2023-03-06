package PersonalStudy;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedvsArray {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        //runtime trials

        long startTime;
        long endTime;
        long elapseTime;

        for(int i = 0; i < 1000000; i++){
            linkedList.add(i);
            arrayList.add(i);
        }

        startTime = System.nanoTime();
        //do something
        //linkedList.get(0); //lose
        //linkedList.get(500000); //lose
        //linkedList.get(999999); //lose
        //linkedList.remove(0); //win
        //linkedList.remove(500000); //lose
        linkedList.remove(999999); //lose

        endTime =System.nanoTime();

        elapseTime = endTime - startTime;

        System.out.println("LinkedList:\t" + elapseTime + " ns");

        
        startTime = System.nanoTime();
        //do something
        //arrayList.get(0); //win
        //arrayList.get(500000); //win
        //arrayList.get(999999); //win
        //arrayList.remove(0); //lose
        //arrayList.remove(500000); //win
        arrayList.remove(999999); //win

        endTime =System.nanoTime();

        elapseTime = endTime - startTime;

        System.out.println("ArrayList:\t" + elapseTime + " ns");
    }
}
