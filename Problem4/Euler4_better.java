public class Euler4 {
    public static int largestPalindrome(int digits){
        if( digits < 2) {
            return 0;
        }
        int max = (int)Math.pow(10,digits);
        int currProduct;
        int currPalindrome = 0;
        int j;
        int decJ; // variable to hold the decrementer for j
        for(int i = max - 1; i >= max/10; i--) {
            // There is a proof that states that all even-digit 
            // palindromic numbers are divisible by 11
            // our solution space is guaranteed to hold palindromes 
            // of length 2*digit - 1 to 2*digit
            // Since we can expect our largest palindrome to be 2*digit
            // in length we can use this to trim our solution space;

            if( i % 11 == 0 ) {
                // i is divisible by 11
                j = max - 1;
                decJ = 1;
            } else {
                // j must be divisible by 11
                j = (max - 1)/11 * 11;
                decJ = 11;
            }

            // only check j >= i to avoid looking at the same numbers twice
            while(j >= i) {
                currProduct = i * j;
                if( currProduct < currPalindrome ) {
                    // future values for j will be too small as well
                    break;
                }
                if( isPalindrome(currProduct) ) {
                    currPalindrome = currProduct;
                }
                j -= decJ;
            }
        }
        return currPalindrome;
    }

    public static boolean isPalindrome(int testValue) {
        String test = Integer.toString(testValue);
        int length = test.length();
        for(int i = 0; i < (length / 2); i++ ) {
            if( test.charAt(i) != test.charAt(length - 1 - i) ) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){
        //Scanner reader = new Scanner(System.in);
        //System.out.print("Enter a number: ");
        //int n = reader.nextInt();
        System.out.println(largestPalindrome(3));
    }
}