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

            // Fib(n+3) = Fib(n+2) + Fib(n+1);
            // Fib(n+2) = Fib(n+1) + Fib(n)
            // Fib(n+1) = Fib(n) + Fib(n-1)
            // +> Fib(n+2) = 2 * Fib(n) + Fib(n-1)
            // => Fib(n+3) = Fib(n+2) + Fib(n) + Fib(n-1)
                tempFib = 2 * currFib + lastFib;  // tempFib = Fib(n+2)
                currFib = tempFib + currFib + lastFib;
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