import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Lab2App {

    static int count = 0;

    public static void main(String[] args) throws Exception {
        testSortingAlgorithm(Lab2App::selectionSort, "selectionSort.csv");
        testSortingAlgorithm(Lab2App::bubbleSort, "bubblesort.csv");
        testSortingAlgorithm(Lab2App::bubbleSortEfficient, "bubblesortefficient.csv");
        //LinearSearch(null, 3);
    }

    static void selectionSort(int[] input) {
        count = 0;
        for (int i = 0; i < input.length; i++) {
            count++;
            int min = -1, position = i;
            for (int j = i; j < input.length; j++) {
                count++;
                if (min == -1 || input[j] < min) {
                    count++;
                    min = input[j];
                    position = j;
                }
            }
            input[position] = input[i];
            input[i] = min;
        }
    }

    static void bubbleSort(int[] input) {
        count = 0;
        for (int i = 0; i < input.length; i++) {
            count++;
            for (int j = i + 1; j < input.length - 1; j++) {
                count++;
                if (input[i] > input[j]) {
                    count++;
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
    }

    static void bubbleSortEfficient(int[] input){
        count = 0;
        boolean swapped = false;
        for(int i=0;i<input.length - 1;i++){
            swapped = false;
            count++;
            for(int j=i + 1; j<input.length; j++){
                count++;
                if(input[i] > input[j]){
                    count++;
                    swapped = true;
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }

            if(!swapped){
                break;
            }
        }
    }

    static int LinearSearch(int[] input, int target){
        for(int i = 0; i<input.length-1; i++){
            if(input[i] == target){
                return i;
            }
        }

        return -1;
    }

    static void testSortingAlgorithm(SortingAlgorithm sorter, String outputFilename) {

        int start = 5, end = 100;

        int[] best = new int[end - start];
        int[] average = new int[end - start];
        int[] worst = new int[end - start];

        for (int i = 5; i < 100; i++) {
            int[] bestArray = getBestCaseArray(i);
            int[] averageArray = getAverageCaseArray(i);
            int[] worstArray = getWorstCaseArray(i);

            sorter.sort(bestArray);
            best[i - start] = count;

            sorter.sort(averageArray);
            average[i - start] = count;

            sorter.sort(worstArray);
            worst[i - start] = count;
        }

        StringBuilder output = new StringBuilder();
        output.append("n,ops-best,ops-average,ops-worst\n");

        for (int i = 0; i < best.length; i++) {
            int n = i + start;
            output.append(n)
                  .append(",")
                  .append(best[i])
                  .append(",")
                  .append(average[i])
                  .append(",")
                  .append(worst[i])
                  .append("\n");
        }
        writeToCSV(outputFilename, output.toString());
    }

    static int[] getBestCaseArray(int length) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            int offset = (i > 0) ? array[i - 1] : 0;
            array[i] = new Random().nextInt(100) + offset;
        }
        return array;
    }

    static int[] getWorstCaseArray(int length) {
        int[] temp = getBestCaseArray(length);
        int[] array = new int[length];

        for (int i = 0; i < temp.length; i++) {
            array[length - 1 - i] = temp[i];
        }
        return array;
    }

    static int[] getAverageCaseArray(int length) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(6000);
        }
        return array;
    }

    static void writeToCSV(String filename, String data){
        try(FileWriter fw = new FileWriter(filename); BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(data);
            bw.close();
            fw.close();
        }catch(IOException ex){
            System.out.println("Error writing file: " + ex.getMessage());
        }
    }
}
