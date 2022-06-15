package src;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i]; // in-place array update
            }
        }
        return index+1; // using index as a counter, need to add 1 since starting at 0.
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray tester = new RemoveDuplicatesFromSortedArray();
        int[] input1 = new int[]{1, 1, 2};
        System.out.println(tester.removeDuplicates(input1));
        System.out.println(Arrays.toString(input1));
        int[] input2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(tester.removeDuplicates(input2));
        System.out.println(Arrays.toString(input2));
    }
}
