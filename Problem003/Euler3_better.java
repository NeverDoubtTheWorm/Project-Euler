public class Euler3 {
    public static long calculatelargestPrimeFactor(long value){
        if( value < 1) {
            return 0;
        }
        long remainingValue = value;
        long testFactor = 2;
        long sqrtChecker = testFactor * testFactor;
        while(  (sqrtChecker <= remainingValue) && 
              ((remainingValue & 1) == 0) ) {
            // remove all twos from the factorization so we can 
            // speed up the rest the check
            remainingValue /= testFactor;
        }

        testFactor++;
        sqrtChecker = testFactor * testFactor;
        while( sqrtChecker <= remainingValue) {
            while(  (sqrtChecker <= remainingValue) && 
                   ((remainingValue % testFactor) == 0 ) {
                // testFactor is a factor of remainingValue
                remainingValue /= testFactor;
                // remove all instances of this factor 
                // from remainingValue
            }
                // incrementing by two to ignore even numbers
            ++testFactor;
              testFactor++;
            sqrtChecker = testFactor * testFactor;
        }
        // remainingValue should hold the larges Prime Factor 
        return remainingValue;
    }
    public static void main(String args[]){
        //Scanner reader = new Scanner(System.in);
        //System.out.print("Enter a number: ");
        //long n = reader.nextLong();
        System.out.println(calculatelargestPrimeFactor(600851475143L));
    }
}