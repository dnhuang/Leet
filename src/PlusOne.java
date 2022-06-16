package src;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1] = digits[digits.length-1] + 1;
        int index = digits.length-1;

        // Loop for carry overs, keep looping of updated index is equal to 10
        while (digits[index] == 10) {
           digits[index] = 0; // resets 10 to 0 due to carry over
            if (index == 0) { // carried all the way to front, need to modify size of digits
                int[] expandedDigits = new int[digits.length + 1];
                System.arraycopy(digits, 0, expandedDigits, 1, digits.length); // copy digits over
                expandedDigits[0] = 1; // the carried over 1
                return expandedDigits;
            }
           digits[index - 1] = digits[index - 1] + 1; // keep adding the carry over
           index--;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne tester = new PlusOne();
        int[] input1 = new int[]{1, 2, 3,};
        int[] input2 = new int[]{4, 3, 2, 1};
        int[] input3 = new int[]{9};
        System.out.println(Arrays.toString(tester.plusOne(input1)));
        System.out.println(Arrays.toString(tester.plusOne(input2)));
        System.out.println(Arrays.toString(tester.plusOne(input3)));
    }
}
