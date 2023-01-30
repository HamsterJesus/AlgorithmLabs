public class PowerExperiments {
    public static void main(String[] args) throws Exception {
        simplePowerExperiments();
    }

    static int count = 0;

    static double power(double x, int n){
        double p = 1;

        for(int i = 1; i <= n; i++){
            p *= x;
            count++;
        }

        return p;
    }

    static void simplePowerExperiments(){
        System.out.println("n, count");
        for(int i = 0; i<20; i++){
            count = 0;
            power(2, i);
            System.out.println(i + "," + count);
        }

    }
}
