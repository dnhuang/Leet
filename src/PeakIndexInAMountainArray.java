package src;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex)/2;

            // Edge cases for out of bounds left or right
            if (midIndex == 0) {
                return rightIndex;
            } else if (midIndex == arr.length - 1) {
                return leftIndex;
            }

            if (arr[midIndex] > arr[midIndex - 1] && arr[midIndex] > arr[midIndex + 1]) {
                return midIndex;
            } else if (arr[midIndex] < arr[midIndex - 1]) { // move left direction, update right bound
                rightIndex = midIndex - 1;
            } else if (arr[midIndex] > arr[midIndex - 1]) { // move right direction, update left bound
                leftIndex = midIndex + 1;
            }
        }
        return leftIndex;
    }

    public static void main(String[] args) {
        PeakIndexInAMountainArray tester = new PeakIndexInAMountainArray();
        int[] input1 = new int[]{0, 1, 0};
        int[] input2 = new int[]{0, 2, 1, 0};
        int[] input3 = new int[]{0, 10, 5, 2};
        System.out.println(tester.peakIndexInMountainArray(input1));
        System.out.println(tester.peakIndexInMountainArray(input2));
        System.out.println(tester.peakIndexInMountainArray(input3));
        int[] input4 = new int[]{18, 29, 38, 59, 98, 100, 99, 98, 90};
        System.out.println(tester.peakIndexInMountainArray(input4));
        int[] input5 = new int[]{3, 5, 3, 2, 0};
        System.out.println(tester.peakIndexInMountainArray(input5));
    }
}
