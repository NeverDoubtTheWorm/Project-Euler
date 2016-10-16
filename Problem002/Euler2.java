public class Euler2 {
    public static int calculateEvenFibSum(int below){
        if( below < 1) {
            return 0;
        }
        int sum = 0;
        int currFib = 1;
        int lastFib = 1;
        int tempFib;
        while( currFib < below) {
            if( (currFib & 1) == 0) { // check if currFib is even
                sum += currFib;
            }
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