import java.util.LinkedHashSet;
import java.util.Iterator;
public class Euler7 {
    public static int getNthPrime(int n){
        if(n < 1) {
            return -1;
        } else if ( n == 1 ) {
            return 2;
        } else if( n == 2 ) {
            return 3;
        }
        // using LinkedHashSet for Consistent ordering
        // (in order of insertion which is also ascending)
        LinkedHashSet<Integer> primeSet = new LinkedHashSet<>();
        primeSet.add(2);
        primeSet.add(3);
        int testValue;
        // create a set of primes to check if our next value is prime
        for( int i = 3; primeSet.size() < n; i++) {
            // all primes greater than 3 
            // can be written as 6k+1 or 6k-1

            //check 6i-1
            testValue = 6 * i - 1;
            if( isPrime( testValue, primeSet.iterator() ) ) {
                primeSet.add(testValue);
                if( primeSet.size() == n ) {
                    return testValue;
                }
            }

            //check 6i+1
            testValue += 2;
            if( isPrime( testValue, primeSet.iterator() ) ) {
                primeSet.add(testValue);
                if( primeSet.size() == n ) {
                    return testValue;
                }
            }
        }

        return -1;
    }

    public static boolean isPrime(  int testValue, 
                                    Iterator<Integer> primeIterator ) {
        // in this case we could remove the first two elements 
        // since we know they are two and 3 
        // AND 6k +- 1 cannot be divisible by 2 or 3
        // but that would make this function less general

        if( testValue < 2) {
            return false;
        }

        int prevPrimes;
        while( primeIterator.hasNext() ) {
            prevPrimes = primeIterator.next();
            if( prevPrimes * prevPrimes > testValue) {
                //only check values up to the sqrt of the testValue
                break;
            }
            if( testValue % prevPrimes == 0 ) {
                // test is divisible by a previous prime number
                return false;
            }
        }
        // not divisible by any prior prime number
        return true;
    }

    public static void main(String args[]){
        System.out.println(getNthPrime(10001));
    }
}