public class Euler12 {
    public static long getFirstTriangleNum(int divisors){
        // a triangle number is defined by adding natural numbers
        //  if f(n) gives us the nth triangle number we can write
        //  the n+1th triangle number as f(n+1) = f(n) + (n+1)
        //  where f(0) is set to 0 for recursion's sake and n > 0

        long curTriangleNum = 1;
        int n = 1; // represents that this is the nth triangle number

        int numDivisors = 1;

        while( numDivisors < divisors ) {
            curTriangleNum += ++n;
            numDivisors = getDivisorCount(curTriangleNum);
        }
        
        return curTriangleNum;
    }
    public static int getDivisorCount(long num) {
        int numDivisors = 1;
        if( num < 0 ) {
            num *= -1;
            numDivisors++;
        }
        if( num == 1 ) {
            return numDivisors;
        }
        numDivisors++;
        if( num == 0 ) {
            return numDivisors;
        }

        int sqrtNum = (int) Math.sqrt(num);
        if( (num % sqrtNum) == 0 ) {
            numDivisors++; //sqrt can only appear once in factor list
        }
        for(int i = 2; i < sqrtNum; i++) {
            if( (num % i) == 0 ) {
                numDivisors++; // add i
                numDivisors++; // add num / i
            }
        }

        return numDivisors;
    } 
    
    public static void main(String args[]){
        System.out.println(getFirstTriangleNum(5));
    }
}