public class Day2 {

    public static int[] reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }

        return nums;
    }

    public static void rotateArrayByOne(int[] nums, int swaps) {
        int n = nums.length;
        int k = swaps % n;
        System.out.println(k);

        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);

        for (int x : nums)
            System.out.print(x + " ");
    }

    public static int removeDuplicates(int[] nums) {
        int index = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 3, 3, 5, 6 };
        System.out.println(removeDuplicates(arr));
    }
}

/*
 * Given an integer array nums and a non-negative integer k, rotate the array to
 * the left by k steps.
 * 
 * Example 1:
 * Input: nums = [1, 2, 3, 4, 5, 6], k = 2
 * 
 * Output: nums = [3, 4, 5, 6, 1, 2]
 * 
 * Explanation:
 * 
 * rotate 1 step to the left: [2, 3, 4, 5, 6, 1]
 * 
 * rotate 2 steps to the left: [3, 4, 5, 6, 1, 2]
 * 
 * Example 2:
 * Input: nums = [3, 4, 1, 5, 3, -5], k = 8
 * 
 * Output: nums = [1, 5, 3, -5, 3, 4]
 */

/*
 * Given an integer array nums sorted in non-decreasing order, remove all
 * duplicates in-place so that each unique element appears only once.
 * 
 * Return the number of unique elements in the array.
 * 
 * If the number of unique elements be k, then,
 * 
 * Change the array nums such that the first k elements of nums contain the
 * unique values in the order that they were present originally.
 * The remaining elements, as well as the size of the array does not matter in
 * terms of correctness.
 * The driver code will assess correctness by printing and checking only the
 * first k elements of the modified array.
 * An array sorted in non-decreasing order is an array where every element to
 * the right of an element is either equal to or greater in value than that
 * element.
 * 
 * Example 1:
 * Input: nums = [0, 0, 3, 3, 5, 6]
 * 
 * Output: 4
 * 
 * Explanation:
 * 
 * Resulting array = [0, 3, 5, 6, _, _]
 * 
 * There are 4 distinct elements in nums and the elements marked as _ can have
 * any value.
 * 
 * Example 2:
 * Input: nums = [-2, 2, 4, 4, 4, 4, 5, 5]
 * 
 * Output: 4
 * 
 * Explanation:
 * 
 * Resulting array = [-2, 2, 4, 5, _, _, _, _]
 * 
 * There are 4 distinct elements in nums and the elements marked as _ can have
 * any value.
 */
