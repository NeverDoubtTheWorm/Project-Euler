public class Euler2 {
    public static int calculateEvenFibSum(int below){
        if( below < 2) {
            return 0;
        }
        int sum = 0;
        int currFib = 2;
        int lastFib = 1;
        int tempFib;
        while( currFib < below) {
            sum += currFib;
            // Every third Fib number is even
                tempFib = currFib;
                currFib += lastFib;
                lastFib = tempFib;

                tempFib = currFib;
                currFib += lastFib;
                lastFib = tempFib;

                tempFib = currFib;
                currFib += lastFib;
                lastFib = tempFib;
        }
        
        return sum;
    }
    public static void main(String args[]){
        //Scanner reader = new Scanner(System.in);
        //System.out.print("Enter a number: ");
        //int n = reader.nextInt();
        System.out.println(calculateEvenFibSum(4_000_000));
    }
}