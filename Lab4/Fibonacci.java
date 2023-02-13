public class Fibonacci{
    public static void main(String[] args){
        System.out.println(Fibonacci(4));
    }

    static int Fibonacci(int n){
        if(n<=2){
            return n -1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}