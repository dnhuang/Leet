package src;

public class RemoveElement {
    /**
     * Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums`
     * in-place. The RELATIVE ORDER of the elements MAY BE CHANGED.
     * @param nums integer array to be modified in-place
     * @param val integer to be removed from array
     * @return integer k, the number of elements removed
     */
    public int removeElement(int[] nums, int val) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[i - count] = nums[i];

            if (nums[i] == val) {
                count++;
            }
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        RemoveElement tester = new RemoveElement();
        int[] input1 = new int[]{3, 2, 2, 3};
        int[] input2 = new int[]{0, 1, 2, 2, 3, 0 ,4, 2};
        int[] input3 = new int[]{1};
        System.out.println(tester.removeElement(input1, 3));
        System.out.println(tester.removeElement(input2, 2));
        System.out.println(tester.removeElement(input3, 1));
    }
}
