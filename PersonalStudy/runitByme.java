import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class runitByme {
    public static void main(String[] args) {
        //declare start end point
        int start = 5, end = 100;
        String output = "n,ops\n";

        for(int i = start; i<end; i++){
            //int[] input = arrayGen(i); //running sorted
            int[] input = randomArray(i); //running unsorted
            count = 0;
            myAlgorithmn(input);
            output += i + "," + count + "\n";
        }

        //write
        try(FileWriter fw = new FileWriter("runItByMe.csv"); BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(output);
        } catch(IOException ex){}
    }

    //count decleration (very cool)
    static int count = 0;

    public static int[] arrayGen(int i){
        int[] testArray = new int[i];

        for(int j = 0; j<i; j++){
            testArray[j] = j; //sorted version
        }
        return testArray;
    }

    public static int[] randomArray(int i){
        int[] testArray = new int[i];

        for(int j = 0; j<i;i++){
            int randomInt = (int)(Math.random()*100)+1;
            testArray[j] = randomInt;
        }

        return testArray;
    }

    //actual algorithmn we are timing
    static void myAlgorithmn(int[] input){
        int size = input.length;

        for(int i = 0; i<size; i++){
            count++; //count because we entered the first loop
            for(int j = 0; j<size; j++){ //1
                count++; //count because we entered the second loop
                if(input[j]<input[i]){ //2
                    count++; //count because we entered the if-statement
                    int temp = input[j]; //3
                    input[j] = input[i]; //4
                    input[i] = temp; //5
                }
            }
        }
    }
}
