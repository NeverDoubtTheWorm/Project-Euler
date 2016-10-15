public class Euler8 {
    public static long getLargestProduct(String number, int digits){
        if( number == null || 
            number.length() == 0 || 
            number.length() < digits ) {
            return 0;
        }

        long max = 1;
        long currMax = max;
        //represents n consecutive nines where n is the number of digits
        //  if reached no larger value can be found
        long maxPossible = (long) Math.pow(9, digits);
        //indecies of the currently inspected list of adjacent digits
        int headIndex = 0;
        int tailIndex = 0;
        int head;
        int tail;

        // 
        int zeroCount = 0;

        // get the first product
        for( tailIndex = 0; tailIndex < digits; tailIndex++ ) {
            tail = getValue( number, tailIndex );
            if( tail == 0 ){
                zeroCount++;
            } else {
                // only add the non-zero factors so we can 
                // avoid multiplying for the whole list of factors
                // every time
                max *= tail;
            }
        }

        currMax = max; 

        if( zeroCount > 0 ){
            // max can only be greater than zero if it has no zero factors
            max = 0;
        }

        while( tailIndex < number.length() ) {
            head = getValue( number, headIndex++ );
            tail = getValue( number, tailIndex++ );

            if(head == tail) {
                // nothing needs to be done
                continue;
            }

            if( head != 0 ) {
                // remove head as factor from group
                currMax /= head;
            } else {
                // remove a zero from the factor list
                zeroCount--;
            }

            if( tail != 0 ) {
                // add tail as factor to group
                currMax *= tail;
            } else {
                // add a zero from the factor list
                zeroCount++;
            }

            if( zeroCount == 0 ){
            // currmax only holds a useful value
            //   if it has no zero factors
                if( currMax > max ) {
                    if( currMax < maxPossible ) {
                        max = currMax;
                    } else {
                        return maxPossible;
                    }
                }
            }
        }

        return max;
    }

    public static int getValue(String number, int index) {
        char c = number.charAt(index);
        return Character.getNumericValue(c);
    }
    
    public static void main(String args[]){
        String number = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        System.out.println(getLargestProduct(number, 13));
    }
}