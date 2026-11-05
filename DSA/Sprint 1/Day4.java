import java.util.Arrays;

class Day4 {

    public static int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int posIndex = 0, negIndex = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, -1, -3, -4 };
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }
}

/*
 * Given an integer array nums of even length consisting of an equal number of
 * positive and negative integers.Return the answer array in such a way that the
 * given conditions are met:
 * 
 * Every consecutive pair of integers have opposite signs.
 * For all integers with the same sign, the order in which they were present in
 * nums is preserved.
 * The rearranged array begins with a positive integer.
 * Example 1:
 * Input : nums = [2, 4, 5, -1, -3, -4]
 * 
 * Output : [2, -1, 4, -3, 5, -4]
 */