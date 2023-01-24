import java.util.ArrayList;
import java.util.Arrays;

public class Lab1{
    public static void main(String[] args){
        int[] listOfNumbers = {12, 32, 44}; //create array of numbers

        System.out.println(algo1(listOfNumbers)); // display result of algo1

        String cypherValue = "Burger king foot lettuce";

        System.out.println(algo2(cypherValue));

        int limit = 4;

        System.out.println((Arrays.toString(algo3(limit))));
    }

    public static int algo1(int[] listOfNumbers){
        int total = 1; //set total to 1

        //loop through listOfNumbers
        for(int i = 0; i < listOfNumbers.length; i++){
            total = total * listOfNumbers[i]; //do calc
        }

        return total;
    }

    public static ArrayList<Integer> algo2 (String cypherValue){ 
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < cypherValue.length(); i++){
            result.add((int) cypherValue.charAt(i));
        }
       
       for(int i = 0; i < cypherValue.length(); i++){
            if(result.get(i) == null){
                result.set(i, 1);
            } else {
                result.set(i, result.get(i) + 1);
            }
       }

        return result;
    }

    public static int[] algo3(int limit){
        int[] result = new int[limit];

        if(limit == 0){
            return result;
        }

        result[0] = 1;

        if(limit == 1){
            return result;
        }

        result[1] = 1;

        for(int i = 2; i < limit-1; i++){
            result[i] = result[i-1] + result[i-2];
        }

        return result;
    }
}