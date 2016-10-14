public class Euler5 {
    public static long getSmallestMultiple(int limit){
        if(limit < 2) {
            return 1;
        }
        long smallestMultiple = limit;
        // smallest Multiple must contain factors of limit
        // use longs to prevent overflows during calculations
        for(long i = limit - 1; i > 1; i--) {
        // go backwards to cover numbers with the most factors first
            smallestMultiple = getLCM(smallestMultiple, i);
        }

        return smallestMultiple;
    }

    public static long getLCM(long a, long b){
        if( ( (a % b) != 0 ) && ( (b % a) != 0 ) ) {
            // a and b are not factors of one another 
            return (a * b) / getGCD(a,b);
        } else {
            return (a > b) ? a : b;
        }
    }

    public static long getGCD(long a, long b) {
        //recursive euclid's algorithm
        return (b==0) ? a : getGCD(b, a%b);
    }

    public static void main(String args[]){
        System.out.println(getSmallestMultiple(20));
    }
}