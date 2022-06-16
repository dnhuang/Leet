package src;

public class BinarySearch {
    public int search(int[] nums, int target) {
        // set initial bounds
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        // loop for search
        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2; // set middle to left (start) + half
            if (nums[midIndex] < target) { // target is bigger, update left index
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1; // target is smaller or equal, update right index
            }
            if (nums[midIndex] == target) // check if updated mid index is target
                return midIndex;
        }
        return -1; // target not found
    }

    public static void main(String[] args) {
        BinarySearch tester = new BinarySearch();
        int[] input = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(tester.search(input, 9));
        System.out.println(tester.search(input, 2));
    }
}
