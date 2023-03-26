import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Lab2App {

    static int count = 0;

    public static void main(String[] args) throws Exception {
        // testSortingAlgorithm(Lab2App::selectionSort, "selectionSort.csv");
        // testSortingAlgorithm(Lab2App::bubbleSort, "bubblesort.csv");
        // testSortingAlgorithm(Lab2App::bubbleSortEfficient, "bubblesortefficient.csv");
        // TestSortingForSearch(Lab2App::LinearSearch, "LinearSearch.csv");
        testAddToArray("AddToArray.csv");
        // testLinearSearch("LinearSearch.csv");

        //testing
        //int tempArray[] = {1,2,3,4,5};
        //System.out.println(BinarySearch(tempArray, 3));
        
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

    static int LinearSearch(int input[], int target){
        count = 0;
        for(int i = 0; i<input.length-1; i++){
            count++;
            if(input[i] == target){
                count++;
                return i;
            }
        }
        return -1;
    }

    static int BinarySearch(int input[], int target){
        int low = 0, high = input.length-1, mid = 0;
        count = 0;

        while(low <= high){
            count++;
            mid = (int) Math.floor((high+low)/2); //find mid point

            if(input[mid] == target){ //if target found
                count++;
                return mid;
            } else if(target < input[mid]){ //if target is on the left
                count++;
                high = mid -1; //shift left in array
            } else { //if target is on the right
                count++;
                low = mid +1; //shift right in array
            }
        }


        //return -1; //target not found
        return mid; //adapted version
    }

    static int[] AddToArray(int[] input, int element){
        count = 0;
        int[] newArray = new int[input.length+1];
        int position = BinarySearch(input, element);

        if(element>input[position]){
            position = position +1;
        }

        newArray[position] = element;

        for(int i = 0; i<position -1; i++){
            count++;
            newArray[i] = input[i];
        }

        for(int i = position+1; i<newArray.length-1; i++){
            count++;
            newArray[i] = input[i-1];
        }

        return newArray;
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

    static void TestSortingForSearch(SortingForSearch sorter, String outputFilename) {

        int start = 5, end = 100;

        int[] best = new int[end - start];
        int[] average = new int[end - start];
        int[] worst = new int[end - start];

        for (int i = 5; i < 100; i++) {
            //int[] bestArray = getBestCaseArray(i);
            int[] averageArray = getAverageCaseArray(i);
            //int[] worstArray = getWorstCaseArray(i);

            int tempBest = averageArray[0]; //first item in array
            sorter.sort(averageArray, tempBest);
            best[i - start] = count;

            int tempAvg = averageArray[(int) Math.floor(Math.random()*i)]; //random item in array
            sorter.sort(averageArray, tempAvg);
            average[i - start] = count;

            int tempWorst = averageArray[averageArray.length-1]; //last item in array
            sorter.sort(averageArray, tempWorst);
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


    
    static void testBinarySearch(SortingForSearch sorter, String outputFilename) {

        int start = 5, end = 100;

        int[] best = new int[end - start];
        int[] average = new int[end - start];
        int[] worst = new int[end - start];

        for (int i = 5; i < 100; i++) {
            //int[] bestArray = getBestCaseArray(i);
            int[] averageArray = getAverageCaseArray(i);
            //int[] worstArray = getWorstCaseArray(i);

            int tempBest = averageArray[(int) Math.floor(start/2)]; //first item in array
            sorter.sort(averageArray, tempBest);
            best[i - start] = count;

            int randomPosition = (int) (Math.floor(Math.random()*start));
            int tempAvg = averageArray[randomPosition]; //random item in array
            sorter.sort(averageArray, tempAvg);
            average[i - start] = count;

            int tempWorst = averageArray[start]; //last item in array
            sorter.sort(averageArray, tempWorst);
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

    static void testLinearSearch(String outputFilename){
        //file sizes for each
        int start =5, end = 100;

        StringBuilder output = new StringBuilder();

        output.append("n,ops-best,ops-average,ops-worst\n");

        for(int i = start; i<end; i++){
            int[] bestArray = getBestCaseArray(i);
            int[] averageArray = getAverageCaseArray(i);
            int[] worstArray = getWorstCaseArray(i);

            //best case target is the first value in the array
            int bestTarget = bestArray[0];
            int best = LinearSearch(bestArray, bestTarget);

            //average case target position is random
            int randomPosition = (int) (Math.floor(Math.random()*start));
            int averageTarget = averageArray[randomPosition];
            int average = LinearSearch(averageArray, averageTarget);
            //best[i - start] = count;

            //worst case target position is at the end
            int worstTarget = worstArray[start];
            int worst = LinearSearch(worstArray, worstTarget);
            //best[i - start] = count;

            int n = i + start;
            output.append(n)
                  .append(",")
                  .append(best)
                  .append(",")
                  .append(average)
                  .append(",")
                  .append(worst)
                  .append("\n");
        }

        writeToCSV(outputFilename, output.toString());
    }

    static void testAddToArray(String outputFilename) {

        int start = 5, end = 100;

        int[] best = new int[end - start];
        int[] average = new int[end - start];
        int[] worst = new int[end - start];

        for (int i = 5; i < 100; i++) {
            int[] averageArray = getAverageCaseArray(i);
            bubbleSortEfficient(averageArray);

            int tempBest = averageArray[start]+1; //first item in array
            //tempBest++;
            best = AddToArray(averageArray, tempBest);

            int randomPosition = (int) (Math.floor(Math.random()*start));
            int tempAvg = averageArray[randomPosition]+1; //random item in array
            average = AddToArray(averageArray, tempAvg);

            int tempWorst = averageArray[0]-1; //last item in array
            worst = AddToArray(averageArray, tempWorst);
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
}
