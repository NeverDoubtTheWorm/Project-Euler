public class Euler9 {
    public static int getPyTripletProduct( int sum ) {
        int product = 1;
        int[] pyTriplet = getPyTriplet( sum );
        if( pyTriplet == null || pyTriplet.length != 3 ) {
            product = -1;
        } else {
            for( int i : pyTriplet ) {
                product *= i;
            }
        }
        return product;
    }
    public static int[] getPyTriplet(int sum){
        int a, b, c;
        int aLimit = sum / 3;  // soft limit on the highest value a can have
        for( a = aLimit; a > 0; a-- ) {
            b = 1 + a; // b must be greater than a
            c = sum - a - b; // make sure that the total equals the given sum
            while( c > b ) {
                if( isTriplet(a,b,c) ) {
                    return new int[]{a,b,c};
                }
                c--;
                b++;
            }
        }
        return null;
    }

    public static boolean isTriplet(int a, int b, int c) {
        //returns true if the trio is a valid pythagorean triplet
        return ( ( (c * c) - (a * a) - (b * b) ) == 0 );
    }
    
    public static void main(String args[]){
        System.out.println(getPyTripletProduct(1000));
    }
}