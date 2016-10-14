public class Euler6 {
    public static int getSumSquareDifference(int limit){
        if(limit < 2) {
            return 0;
        }
        int sumSquares = 0;
        for(int i = limit; i > 0; i--) {
            sumSquares += i * i;
        }
        // generate sum of n consecutive numbers in arithmetic series
        int sum = limit * (limit + 1) / 2;
        int squareSums = sum * sum;

        return squareSums - sumSquares;
    }

    public static void main(String args[]){
        System.out.println(getSumSquareDifference(20));
    }
}