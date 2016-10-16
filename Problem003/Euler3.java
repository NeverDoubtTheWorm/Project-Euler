public class Euler3 {
    public static long calculatelargestPrimeFactor(long value){
        if( value < 1) {
            return 0;
        }
        long remainingValue = value;
        long testFactor = 2;
        long sqrtChecker = testFactor * testFactor;
        while( sqrtChecker <= remainingValue) {

            if( (remainingValue % testFactor) == 0) {
                // testFactor is a factor of remainingValue
                remainingValue /= testFactor;
                // reset testFactor for this value in case it 
                // appears multiple times in the factorization
                testFactor--;
            }
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