package PersonalStudy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExperimentalAnalysis{
    public static void main(String[] args) {
        //experimental framework for testing myAlgorithmn
        int start = 2, end = 100; //declare the range of array lengths for testing
        //i.e arrays going from size 5 till size 100 to test diffrent problem sizes

        String output = "n.ops\n"; //column header for csv file

        for(int i=start; i<end; i++){
            int[] input = getArray(i); //call to getArray method
            count = 0;//reset count after each promblem size test
            myAlgorithmn(input);
            output += i + "," + count + "\n"; //csv output now has arraysize and count added
        }

        try(FileWriter fw = new FileWriter("results.csv"); BufferedWriter bw = new BufferedWriter(fw)){ //init file writer to write to file "results.csv" & bufferedwriter to make it faster
            bw.write(output); //write to file
        } catch(IOException ex){} //catch input/output exceptions
    }
    
    private static int[] getArray(int i) {
        int testArray[] = new int[i]; //new array of size i

        for(int j = 0; j<i; j++){ //loop through size
            testArray[j] = j; //add value of j to testArray index j
        }

        return testArray; //pass test array out
    }

    //declare counter for experimental analysis
    static int count = 0;

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
