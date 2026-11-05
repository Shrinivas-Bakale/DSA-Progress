import java.util.Arrays;

public class Day10 {

    public static boolean ls(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                return true;
        }
        return false;
    }

    public static int longestConsecutive(int[] nums) {
        int longest = 1, cnt = 0, lastSmallest = Integer.MIN_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == lastSmallest) {
                cnt++;
                lastSmallest = nums[i];
            } else if (nums[i] != lastSmallest) {
                lastSmallest = nums[i];
                cnt = 1;
            }

            longest = Math.max(longest, cnt);
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(arr));
    }
}
/*
 * Given an array nums of n integers.
 * 
 * Return the length of the longest sequence of consecutive integers. The
 * integers in this sequence can appear in any order.
 * 
 * Example 1:
 * Input: nums = [100, 4, 200, 1, 3, 2]
 * 
 * Output: 4
 * 
 * Explanation:
 * 
 * The longest sequence of consecutive elements in the array is [1, 2, 3, 4],
 * which has a length of 4. This sequence can be formed regardless of the
 * initial order of the elements in the array.
 */