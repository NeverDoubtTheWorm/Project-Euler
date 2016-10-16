public class Euler4 {
    public static int largestPalindrome(int digits){
        if( digits < 2) {
            return 0;
        }
        int max = (int)Math.pow(10,digits);
        int currProduct;
        int currPalindrome = 0;
        // use .9 * max because it's unlikely the 
        // result does not exist in the last 20%
        for(int i = (int)(max * 0.8); i < max; i++) {
            for(int j = (int)(max * 0.8); j < max; j++) {
                currProduct = i * j;
                if( currProduct > currPalindrome &&
                    isPalindrome(currProduct) ) {
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