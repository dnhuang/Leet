package src;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum tester = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        int[] test = tester.twoSum(nums, 9);
        System.out.println(Arrays.toString(test));
        int[] test2 = tester.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(test2));
        int[] test3 = tester.twoSum(new int[]{3, 3}, 6);
        System.out.println(Arrays.toString(test3));
    }
}
