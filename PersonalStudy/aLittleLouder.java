import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class aLittleLouder {
    public static void main(String[] args) {
        int start = 5, end = 100;
        String output = "n,ops\n";

        for(int i = start; i<end; i++){
            int[] input = sortedArray(i);
            count = 0;
            myAlgorithmn(input);
            output += i + "," + count + "\n";
        }

        try(FileWriter fw = new FileWriter("louder.csv"); BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(output);
        } catch(IOException ex){}
    }

    static int count = 0;

    public static int[] sortedArray(int i){
        int[] testArray = new int[i];

        for(int j = 0; i<j; j++){
            testArray[j] = j;
        }

        return testArray;
    }

    public static int[] unsortedArray(int i){
        int[] testArray = new int[i];

        for(int j = 0; j<i; j++){
            int randomint = (int) (Math.random()*100)+1;
            testArray[j] = randomint;
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
