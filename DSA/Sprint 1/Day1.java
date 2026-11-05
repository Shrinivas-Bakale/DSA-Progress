class Day1 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int best = 0, run = 0;

        for (int x : nums) {
            if (x == 1)
                best = Math.max(best, ++run);
            else
                run = 0;
        }
        return best;
    }

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

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        // System.out.println(findMaxConsecutiveOnes(arr));
        rotateArrayByOne(arr, 1);
    }
}

/*
 * Given a binary array nums, return the maximum number of consecutive 1s in the
 * array.
 * 
 * A binary array is an array that contains only 0s and 1s.
 * 
 * Example 1:
 * Input: nums = [1, 1, 0, 0, 1, 1, 1, 0]
 * 
 * Output: 3
 * 
 * Explanation:
 * 
 * The maximum consecutive 1s are present from index 4 to index 6, amounting to
 * 3 1s
 * 
 * Example 2:
 * Input: nums = [0, 0, 0, 0, 0, 0, 0, 0]
 * 
 * Output: 0
 * 
 * Explanation:
 * 
 * No 1s are present in nums, thus we return 0
 */

/*
 * Given an integer array nums, rotate the array to the left by one.
 * 
 * Note: There is no need to return anything, just modify the given array.
 * 
 * Example 1:
 * Input: nums = [1, 2, 3, 4, 5]
 * 
 * Output: [2, 3, 4, 5, 1]
 * 
 * Explanation:
 * 
 * Initially, nums = [1, 2, 3, 4, 5]
 * 
 * Rotating once to left -> nums = [2, 3, 4, 5, 1]
 * 
 * Example 2:
 * Input: nums = [-1, 0, 3, 6]
 * 
 * Output: [0, 3, 6, -1]
 * 
 * Explanation:
 * 
 * Initially, nums = [-1, 0, 3, 6]
 */