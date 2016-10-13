public class Euler4 {
    public static int largestPalindrome(int digits){
        if( digits < 2) {
            return 0;
        }
        int max = (int)Math.pow(10,digits);
        int currProduct;
        int currPalindrome = 0;
        for(int i = max / 10 ; i < max; i++) {
            // only check j >= i to avoid looking at the same numbers twice
            for(int j = max-1; j >= i; j--) {
                currProduct = i * j;
                if( currProduct < currPalindrome ) {
                    // future values for j will be too small as well
                    break;
                }
                if( isPalindrome(currProduct) ) {
                    currPalindrome = currProduct;
                }
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