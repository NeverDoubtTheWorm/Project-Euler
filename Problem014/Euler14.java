public class Euler14 {
    public static int getLongestCollatzChain(int limit){
        // this assumes all numbers in nums have the same number of digits
        if(limit < 1 ) {
            return -1;
        }
        CollatzChainHelper ccHelper = new CollatzChainHelper(limit);
        return ccHelper.getMaxChainStart();
    }
    
    public static void main(String args[]){
        System.out.println(getLongestCollatzChain(1_000_000));
    }
}
class CollatzChainHelper {
    //holds the largest collatz chain starting point we care about
    private int limit;
    //holds the lengths of the Collatz Sequences under our limit
    private int[] collatzChainLength;
    // holds the max starting point under limit
    private int maxNum; 
    // holds the length of the Collatz sequence starting at maxNum
    private int maxLength;
    // holds a marker to help us tell when we filled up our array
    private int generated;

    public CollatzChainHelper(int limit){
        if( limit > 1 ) {
            collatzChainLength = new int[limit];
            this.limit = limit;
            collatzChainLength[0] = 1;
        }

        maxNum = 1;
        maxLength = 1;
        generated = 1;

        // fill up our array
        int num = 1;
        while( (generated < limit) && (num < limit) ) {
            getChainLength(++num);
        }
    }

    public int getChainLength(long num) {
        if(num > limit) {
            // doesn't store values greater than our limit
            if( (num & 1) == 0 ) {// num is even
                return 1 + getChainLength(num/2);
            } else { //num is odd
                return 1 + getChainLength(3*num+1);
            }
        }
        //shift the index to match our array
        int i = (int)num - 1;
        if( i < 0 ) {
            //handle bad call to getChainLength 
            return 0;
        }
        if( collatzChainLength[i] != 0 ) {
            // value has already been set
            return collatzChainLength[i];
        }

        int chainLength = 1; // start our chain here
        if( (num & 1) == 0 ) {// num is even
            chainLength += getChainLength(num/2); 
        } else { //num is odd
            chainLength += getChainLength(3*num+1);
        }
        // check if it beats our longest sequence
        if( chainLength > maxLength ) { 
            maxLength = chainLength;
            maxNum = (int)num;
        }
        // store our relevant and new value and mark the filling of our cache
        collatzChainLength[i] = chainLength;
        generated++;

        return chainLength;
    }

    public int getMaxChainStart() {
        return maxNum;
    }
}