package src;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String intToString = String.valueOf(x);
        for (int i = 0; i <= intToString.length()/2; i++) {
            String currInt = intToString.substring(i, i+1);
            int currIntNew = Integer.valueOf(currInt);
            if (currIntNew != (x%10)) {
                return false;
            }
            x /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber tester = new PalindromeNumber();
        System.out.println(tester.isPalindrome(121));
        System.out.println(tester.isPalindrome(-121));
        System.out.println(tester.isPalindrome(10));
    }
}

