package src;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (right - left > 1) {
            int index = (left + right) / 2;
            if (nums[index] < target) { // target is greater, update left bound
                left = index + 1;
            } else if (nums[index] > target) { // target is smaller, update right bound
                right = index;
            } else {
                return index;
            }
        }

        if (nums[left] == target) { // check if equal to left index element
            return left;
        } else if (nums[right] == target) { // check if equal to right index element
            return right;
        } else if (nums[left] < target && nums[right] > target) { // doesn't exit, insert on right
            return right;
        } else if (nums[right] < target) { // greater than everything, insert rightmost index
            return right + 1;
        }
        return left; // smaller than everything (left guaranteed to be 0), return 0
    }

    /**
     * Second solution done for BinarySearch Study Plan
     * @param nums
     * @param target
     * @return int position of target or where it should be inserted.
     */
    public int searchInsert2(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex)/2;
            if (nums[midIndex] < target) { // target is greater than middle, update left bound to mid + 1
                leftIndex = midIndex + 1;
            } else if (nums[midIndex] > target) { // target is less than middle, update right bound to mid - 1
                rightIndex = midIndex - 1;
            } else {
                return midIndex;
            }
        }
        return leftIndex; // leftIndex has surpassed rightIndex and should be where the element is inserted
    }
    public static void main(String[] args) {
        SearchInsertPosition tester = new SearchInsertPosition();
        int[] input = new int[]{1, 3, 5, 6};
        System.out.println("Test for searchInsert:");
        System.out.println(tester.searchInsert(input, 5));
        System.out.println(tester.searchInsert(input, 2));
        System.out.println(tester.searchInsert(input, 7));
        System.out.println(tester.searchInsert(input, 0));

        System.out.println("Test for searchInsert2:");
        System.out.println(tester.searchInsert2(input, 5));
        System.out.println(tester.searchInsert2(input, 2));
        System.out.println(tester.searchInsert2(input, 7));
        System.out.println(tester.searchInsert2(input, 0));
    }
}
