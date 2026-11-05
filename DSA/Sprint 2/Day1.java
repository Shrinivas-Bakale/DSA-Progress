import java.util.Arrays;

class Day1 {
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        /*
         * int n = nums.length;
         * int[] hashArr = new int[n + 1];
         * 
         * int[] ans = new int[2];
         * 
         * for (int i = 0; i < n; i++) {
         * hashArr[nums[i]]++;
         * }
         * 
         * for (int i = 1; i < hashArr.length; i++) {
         * if (hashArr[i] == 2)
         * ans[0] = i;
         * else if (hashArr[i] == 0)
         * ans[1] = i;
         * }
         * 
         * return ans;
         */

        // Size of the array
        long n = nums.length;

        // Sum of first n natural numbers
        long SN = (n * (n + 1)) / 2;

        // Sum of squares of first n natural numbers
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        /*
         * Calculate actual sum (S) and sum
         * of squares (S2) of array elements
         */
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += nums[i];
            S2 += (long) nums[i] * (long) nums[i];
        }

        // Compute the difference values
        long val1 = S - SN;

        // S2 - S2n = X^2 - Y^2
        long val2 = S2 - S2N;

        // Calculate X + Y using X + Y = (X^2 - Y^2) / (X - Y)
        val2 = val2 / val1;

        /*
         * Calculate X and Y from X + Y and X - Y
         * X = ((X + Y) + (X - Y)) / 2
         * Y = X - (X - Y)
         */
        long x = (val1 + val2) / 2;
        long y = x - val1;

        // Return the results as [repeating, missing]
        return new int[] { (int) x, (int) y };
    }

    public static long numberOfInversions(int[] nums) {
        long pairs = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    pairs++;
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 7, 1, 3, 5 };
        System.out.println(numberOfInversions(arr));
    }
}

/*
 * Given an integer array nums of size n containing values from [1, n] and each
 * value appears exactly once in the array, except for A, which appears twice
 * and B which is missing.
 * 
 * Return the values A and B, as an array of size 2, where A appears in the 0-th
 * index and B in the 1st index.
 * 
 * Note: You are not allowed to modify the original array.
 * 
 * Example 1:
 * Input: nums = [3, 5, 4, 1, 1]
 * 
 * Output: [1, 2]
 * 
 * Explanation:
 * 
 * 1 appears two times in the array and 2 is missing from nums
 * 
 * Example 2:
 * Input: nums = [1, 2, 3, 6, 7, 5, 7]
 * 
 * Output: [7, 4]
 * 
 * Explanation:
 * 
 * 7 appears two times in the array and 4 is missing from nums.
 */

/*
 * Given an integer array nums. Return the number of inversions in the array.
 * 
 * Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 * 
 * It indicates how close an array is to being sorted.
 * A sorted array has an inversion count of 0.
 * An array sorted in descending order has maximum inversion.
 * Example 1:
 * Input: nums = [2, 3, 7, 1, 3, 5]
 * 
 * Output: 5
 * 
 * Explanation:
 * 
 * The responsible indexes are:
 * 
 * nums[0], nums[3], values: 2 > 1 & indexes: 0 < 3
 * 
 * nums[1], nums[3], values: 3 > 1 & indexes: 1 < 3
 * 
 * nums[2], nums[3], values: 7 > 1 & indexes: 2 < 3
 * 
 * nums[2], nums[4], values: 7 > 3 & indexes: 2 < 4
 * 
 * nums[2], nums[5], values: 7 > 5 & indexes: 2 < 5
 */