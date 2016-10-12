public class Euler1 {
    public static int calculate(int below, int[] A){
        int sum = 0;
        int k = 0;
        for( int i = 0; i < A.length; i++ ) {
            for( int multiple = A[i]; multiple < below; multiple += A[i] ) {
                for( k = 0; k < i; k++ ) {
                    if( multiple % A[k] == 0 ) {
                        break;
                    }
                }
                if ( k == i ) {
                    sum += multiple;
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