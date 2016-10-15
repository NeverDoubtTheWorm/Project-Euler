public class Euler7 {
    public static int getNthPrime(int n){
        if(n < 1) {
            return -1;
        } else if ( n == 1 ) {
            return 2;
        } else if( n == 2 ) {
            return 3;
        }
        
        int primesFound = 2; // 2 and 3
        int testValue;
        for( int i = 1; primesFound < n; i++) {
            // all primes greater than 3 
            // can be written as 6k+1 or 6k-1

            //check 6i-1
            testValue = 6 * i - 1;
            if( isPrime( testValue ) ) {
                primesFound++;
                if( primesFound == n ) {
                    return testValue;
                }
            }

            //check 6i+1
            testValue += 2;
            if( isPrime( testValue ) ) {
                primesFound++;
                if( primesFound == n ) {
                    return testValue;
                }
            }
        }

        return -1;
    }

    public static boolean isPrime( int testValue ) {
        if( testValue < 2) {
            return false;
        } else if( testValue < 4) {
            //only includes 2 and 3
            return true;
        } else if( (testValue & 1) == 0) {
            //even numbers cannot be prime
            return false;
        } else if( testValue < 9 ) {
            // values left in this range are 5 and 7
            return true;
        } else if ( (testValue % 3) == 0) {
            return false;
        } else {

            int tester=5;
            // obly check values less than or equal to the sqrt of testValue
            int limit = (int)Math.sqrt(testValue) + 1;
            
            for( int i = 1; tester < limit; i++ ) {
                // all primes greater than 3 
                // can be written as 6k+1 or 6k-1

                //check 6i-1
                tester = 6 * i - 1;
                if( (testValue % tester) == 0 ) {
                    return false;
                }
                //check 6i+1
                tester += 2;
                if( (testValue % tester) == 0 ) {
                    return false;
                }
            }
        
            // not divisible by any prior prime number
            return true;
        }
    }

    public static void main(String args[]){
        System.out.println(getNthPrime(10001));
    }
}