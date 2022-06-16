package src;

public class MaximumSubarray {

    /**
     * Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has
     * the largest sum and return its sum
     * @param nums
     * @return largest int sum of a contiguous subarray in `nums`.
     */
    public int maxSubArray(int[] nums) {
        /**
         * O(n) time complexity: https://www.youtube.com/watch?v=5WZl3MMT0Eg
         * Loops through once, gets rid of "negative" prefixes.
         */
        int currSum = 0;
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (currSum < 0) { // if prefix is negative, reset pointer to 0
                currSum = 0;
            }
            currSum += nums[i]; // compute the sum
            maxSum = Math.max(currSum, maxSum); // compares sum to find max
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray tester = new MaximumSubarray();
        int[] input1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] input2 = new int[]{1};
        int[] input3 = new int[]{5, 4, -1, 7, 8};
        System.out.println(tester.maxSubArray(input1));
        System.out.println(tester.maxSubArray(input2));
        System.out.println(tester.maxSubArray(input3));
    }
}
