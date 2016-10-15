import java.util.LinkedHashSet;
import java.util.Iterator;
public class Euler7 {
    public static int getNthPrime(int n){
        if(n < 1) {
            return -1;
        } else if ( n == 1 ) {
            return 2;
        }
        // using LinkedHashSet for Consistent ordering
        // (in order of insertion which is also ascending)
        LinkedHashSet<Integer> primeSet = new LinkedHashSet<>();
        primeSet.add(2);
        int test = 3;
        //create a set of the first n-1 primes
        for( test = 3; primeSet.size() < n-1; test += 2) {
            if( isPrime( test, primeSet.iterator() ) ) {
                primeSet.add(test);
            }
        }

        while( primeSet.size() != n) {
            if( isPrime( test, primeSet.iterator() ) ) {
                return test;
            }
            test += 2;
        }

        return -1;
    }

    public static boolean isPrime(  int testValue, 
                                    Iterator<Integer> primeIterator ) {
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