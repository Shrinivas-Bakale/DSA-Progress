import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7 {

    // Helper function to reverse the array
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Helper Function to swap two numbers in an array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length; // Size of the given array

        // To store the index of the first smaller element from right
        int ind = -1;

        // Find the first index from the end where nums[i] < nums[i+1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        /*
         * If no such index exists, array is in descending order
         * So, reverse it to get the smallest permutation
         */
        if (ind == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Find the element just greater than nums[ind] from the end
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind); // Swap with nums[ind]
                break;
            }
        }

        // Reverse the right half to get the next smallest permutation
        reverse(nums, ind + 1, n - 1);
        return;
    }

    public static List<Integer> majorityElementTwo(int[] nums) {
        /*
         * List<Integer> ans = new ArrayList<>();
         * 
         * int maxCount = nums.length / 3;
         * HashMap<Integer, Integer> map = new HashMap<>();
         * 
         * for (int i : nums) {
         * map.put(i, map.getOrDefault(i, 0) + 1);
         * }
         * 
         * for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         * if (entry.getValue() > maxCount) {
         * ans.add(entry.getKey());
         * }
         * }
         * 
         * return ans;
         */

        List<Integer> ans = new ArrayList<>();

        int cnt1 = 0, cnt2 = 0;
        int el1 = 0, el2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (cnt1 == 0 && nums[i] != el2) {
                el1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0 && nums[i] != el1) {
                el2 = nums[i];
                cnt2 = 1;
            } else if (nums[i] == el1)
                cnt1++;
            else if (nums[i] == el2)
                cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }

        int maxCount = nums.length / 3 + 1;

        cnt1 = 0;
        cnt2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (el1 == nums[i])
                cnt1++;
            else if (el2 == nums[i])
                cnt2++;
        }

        if (cnt1 >= maxCount)
            ans.add(el1);
        if (cnt2 >= maxCount && el1 != el2)
            ans.add(el2);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 1, 3, 2 };
        System.out.println(majorityElementTwo(arr));
    }
}

/*
 * A permutation of an array of integers is an arrangement of its members into a
 * sequence or linear order.
 * 
 * For example, for arr = [1,2,3], the following are all the permutations of
 * arr:
 * 
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1].
 * 
 * The next permutation of an array of integers is the next lexicographically
 * greater permutation of its integers.
 * 
 * More formally, if all the permutations of the array are sorted in
 * lexicographical order, then the next permutation of that array is the
 * permutation that follows it in the sorted order.
 * 
 * If such arrangement is not possible (i.e., the array is the last
 * permutation), then rearrange it to the lowest possible order (i.e., sorted in
 * ascending order).
 * 
 * You must rearrange the numbers in-place and use only constant extra memory.
 * 
 * ### Example 1:
 ** 
 * Input:** nums = [1,2,3]
 ** 
 * Output:** [1,3,2]
 ** 
 * Explanation:**
 * The next permutation of [1,2,3] is [1,3,2].
 */

/*
 * Given an integer array nums of size n. Return all elements which appear more
 * than n/3 times in the array. The output can be returned in any order.
 * 
 * Example 1:
 * Input: nums = [1, 2, 1, 1, 3, 2]
 * 
 * Output: [1]
 * 
 * Explanation:
 * 
 * Here, n / 3 = 6 / 3 = 2.
 * 
 * Therefore the elements appearing 3 or more times is : [1]
 * 
 * Example 2:
 * Input: nums = [1, 2, 1, 1, 3, 2, 2]
 * 
 * Output: [1, 2]
 * 
 * Explanation:
 * 
 * Here, n / 3 = 7 / 3 = 2.
 * 
 * Therefore the elements appearing 3 or more times is : [1, 2]
 */