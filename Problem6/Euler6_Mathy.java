public class Euler6 {
    public static long getSumSquareDifference(long limit){
        if(limit < 2) {
            return 0;
        }
        //return getSquareSums(limit) - getSumSquares(limit);

        // this is equal to ( n(n+1)/2 )^2 - n(n+1)(2n+1)/6
        //   => (n(n+1)/2) (n(n+1)/2 - (2n+1)/3)
        //   => (n(n+1)/2) ((3n^2 + 3n - 4n - 2)/6)
        //   => (n(n+1)/2) ((3n^2 - n -2 )/6)
        //   => ((n^2 + n)(3n^2 - n - 2))/12
        //   => (3n^4 - n^3 - 2n^2 + 3n^3 - n^2 - 2n) / 12
        //   => (3n^4 + 2n^3 - 3n^2 -2n) / 12
        //   => (n^4 - n^2)/4 + (n^3 - n)/6
        //   => n^2(n^2 - 1)/4 + n(n^2 - 1)/6
        //   => n(n^2 - 1) (3n + 2) / 12
        long a = limit;
        long b = limit * limit - 1;
        long c = limit * 3 + 2;

        return a * b * c / 12
    }

    public static long getSumSquares(long limit) {
        // The sum of n squares is given by the formula 
        // n(n+1)(2n+1)/6
        return (limit) * (limit + 1) * (2 * limit + 1) / 6;
    }

    public static long getSquareSums(long limit) {
        // generate sum of n consecutive numbers in arithmetic series
        // sum = n(n+1)/2
        long sum = limit * (limit + 1) / 2;
        return sum * sum;
    }

    public static void main(String args[]){
        System.out.println(getSumSquareDifference(20));
    }
}