public class Euler1 {
    public static int calculate(int below, int[] A){
        int sum = 0;
        int count = 0;
        // assume A only has distinct values greater than 1
        for(int factor : A ){
            // count the number of multiples below the limit
            count = (below-1) / factor; 
            if( count > 0 ){
                // use gauss's law to get the sum of all the multiples
                sum += count * (factor + factor * count ) / 2;
            }
        }
        
        for(int factor1 : A ){
            for(int factor2 : A ){
                if(factor1 == factor2) {
                    // ignore same index
                    break;
                }
                // remove 1 copy of the shared multiples so they are not double counted
                int factor = factor1 * factor2;
                count = (below-1) / factor;
                if( count > 0 ){
                    sum -= count * (factor + factor * count ) / 2;
                }
            }
        }
        return sum;
    }
    public static int calculate(int below){
        if( below < 1 ) {
            return 0;
        }
        int[] A = {3, 5};
        return calculate( below, A );
    }
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = reader.nextInt();
        System.out.println(calculate(n));
    }
}