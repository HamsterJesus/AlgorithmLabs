public class Fibonacci{

    private static int[] fibonacciCache;
    public static void main(String[] args){
        int n = 6;

        fibonacciCache = new int[n + 1];

        System.out.println(Iterativefibonacci(n));
    }

    //actual method
    static int fibonacci(int n){
        //int count 
        if(n<=2){ //base case to prevent infinite recursion
            return n -1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    static int Iterativefibonacci(int n){
        //int count 
        if(n<=2){ //base case to prevent infinite recursion
            return n -1;
        }

        if(fibonacciCache[n] != 0){ //if there is a value in fibonacciCache use it
            return fibonacciCache[n];
        }

        int nthFibonacciNumber = Iterativefibonacci(n-1) + Iterativefibonacci(n-2);
        fibonacciCache[n] = nthFibonacciNumber;

        return nthFibonacciNumber;
    }
}