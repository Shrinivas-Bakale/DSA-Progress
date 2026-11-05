
public class Day6 {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sortZeroOneTwo(int[] nums) {
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = i + 1; j < nums.length; j++) {
        // if (nums[i] > nums[j]) {
        // int temp = nums[i];
        // nums[i] = nums[j];
        // nums[j] = temp;
        // }
        // }
        // }

        // Better implementation
        // int count0 = 0, count1 = 0, count2 = 0;

        // int index = 0;

        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] == 0) {
        // count0++;
        // } else if (nums[i] == 1) {
        // count1++;
        // } else if (nums[i] == 2) {
        // count2++;
        // }
        // }

        // for (int i = 0; i < count0; i++) {
        // nums[index] = 0;
        // index++;
        // }
        // for (int i = 0; i < count1; i++) {
        // nums[index] = 1;
        // index++;
        // }
        // for (int i = 0; i < count2; i++) {
        // nums[index] = 2;
        // index++;
        // }

        // Optimal
        // Dutch national flag algorithm
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                mid++;
                low++;
            } else if (nums[mid] == 1)
                mid++;
            else if (nums[mid] == 2) {
                swap(nums, mid, high);

                high--;
            }
        }

        for (int i : nums) {
            System.out.print(i + " ");
        }

    }

    public static int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            /*
             * Variable to store the sum
             * of the current subarray
             */
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxi = Math.max(maxi, sum);
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 1, 0 };
        // System.out.println(maxSubArray(arr));
        sortZeroOneTwo(arr);
    }
}

/*
 * Problem 1:
 * Given an array nums consisting of only 0, 1, or 2. Sort the array in
 * non-decreasing order.
 * The sorting must be done in-place, without making a copy of the original
 * array.
 * 
 * Example 1:
 * Input: nums = [1, 0, 2, 1, 0]
 * Output: [0, 0, 1, 1, 2]
 * 
 * Explanation:
 * 
 * The nums array in sorted order has 2 zeroes, 2 ones and 1 two
 * 
 * Example 2:
 * Input: nums = [0, 0, 1, 1, 1]
 * 
 * Output: [0, 0, 1, 1, 1]
 * 
 * Explanation:
 * 
 * The nums array in sorted order has 2 zeroes, 3 ones and zero twos
 */

/*
 * Kadane's Algorithm
 * Given an integer array nums, find the subarray with the largest sum and
 * return the sum of the elements present in that subarray.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * Example 1:
 * Input: nums = [2, 3, 5, -2, 7, -4]
 * 
 * Output: 15
 * 
 * Explanation:
 * 
 * The subarray from index 0 to index 4 has the largest sum = 15
 * 
 * Example 2:
 * Input: nums = [-2, -3, -7, -2, -10, -4]
 * 
 * Output: -2
 * 
 * Explanation:
 * 
 * The element on index 0 or index 3 make up the largest sum when taken as a
 * subarray
 */