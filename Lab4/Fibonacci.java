public class Fibonacci{
    public static void main(String[] args){
        System.out.println(fibonacci(5));
    }

    //actual method
    static int fibonacci(int n){
        //int count 
        if(n<=2){
            return n -1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}