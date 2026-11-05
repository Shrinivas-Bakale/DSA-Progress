import java.util.*;

public class Day3 {

    public static int majorityElement(int[] nums) {
        /*
         * HashMap<Integer, Integer> map = new HashMap<>();
         * int maxFrequency = 0;
         * int maxElement = 0;
         * 
         * for (int i : nums) {
         * map.put(i, map.getOrDefault(i, 0) + 1);
         * }
         * 
         * for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         * System.out.println(entry.getKey() + " - " + entry.getValue());
         * if (entry.getValue() > maxFrequency) {
         * maxFrequency = entry.getValue();
         * maxElement = entry.getKey();
         * }
         * }
         * 
         * return maxElement;
         */

        /* Moores voting algorithm */
        int count = 0;
        int el = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                el = nums[i];
                count = 1;
            } else if (el == nums[i])
                count++;
            else
                count--;
        }

        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el)
                count1++;
        }

        if (count1 > nums.length / 2)
            return el;
        else
            return -1;
    }

    public static List<Integer> leaders(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                list.add(nums[i]);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public static int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length];
        int posIndex = 0;
        int[] neg = new int[nums.length];
        int negIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos[posIndex] = nums[i];
                posIndex++;
            } else {
                neg[negIndex] = nums[i];
                negIndex++;
            }
        }

        int[] c = new int[posIndex + negIndex];
        posIndex = 0;
        negIndex = 0;

        for (int i = 0; i < c.length; i++) {
            if (i % 2 == 0) {
                c[i] = pos[posIndex];
                posIndex++;
            } else {
                c[i] = neg[negIndex];
                negIndex++;
            }
        }

        return c;
    }

    public static int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> UnionList = new ArrayList<>();
        int i = 0, j = 0;
        int n = nums1.length;
        int m = nums2.length;

        while (i < n && j < m) {
            // Case 1 and 2
            if (nums1[i] <= nums2[j]) {
                if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                    UnionList.add(nums1[i]);
                }
                i++;
            }
            // Case 3
            else {
                if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
                    UnionList.add(nums2[j]);
                }
                j++;
            }
        }

        // Add remaining elements of nums1, if any
        while (i < n) {
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                UnionList.add(nums1[i]);
            }
            i++;
        }

        // Add remaining elements of nums2, if any
        while (j < m) {
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
                UnionList.add(nums2[j]);
            }
            j++;
        }

        // Convert List<Integer> to int[]
        int[] Union = new int[UnionList.size()];
        for (int k = 0; k < UnionList.size(); k++) {
            Union[k] = UnionList.get(k);
        }

        return Union;

        // TreeSet<Integer> tree = new TreeSet<>();

        // for (int i = 0; i < nums1.length; i++) {
        // tree.add(nums1[i]);
        // }

        // for (int i = 0; i < nums2.length; i++) {
        // tree.add(nums2[i]);
        // }

        // int[] arr = new int[tree.size()];
        // int i = 0;
        // for (int num : tree) {
        // arr[i] = num;
        // i++;
        // }

        // return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 1, 2, 7 };
        System.out.println(Arrays.toString(unionArray(arr, arr2)));
    }
}

/*
 * Problem 1:
 * Given an integer array nums of size n, return the majority element of the
 * array.
 * 
 * The majority element of an array is an element that appears more than n/2
 * times in the array. The array is guaranteed to have a majority element.
 * Example 1:
 * Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]
 * 
 * Output: 7
 * 
 * Explanation:
 * 
 * The number 7 appears 5 times in the 9 sized array
 * 
 * Example 2:
 * Input: nums = [1, 1, 1, 2, 1, 2]
 * 
 * Output: 1
 * 
 * Explanation:
 * 
 * The number 1 appears 4 times in the 6 sized array
 */

/*
 * Problem 2:
 * Given an integer array nums, return a list of all the leaders in the array.
 * 
 * A leader in an array is an element whose value is strictly greater than all
 * elements to its right in the given array. The rightmost element is always a
 * leader. The elements in the leader array must appear in the order they appear
 * in the nums array.
 * 
 * Input: nums = [1, 2, 5, 3, 1, 2]
 * 
 * Output: [5, 3, 2]
 * 
 * Explanation:
 * 
 * 2 is the rightmost element, 3 is the largest element in the index range [3,
 * 5], 5 is the largest element in the index range [2, 5]
 */

/*
 * Problem 3
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
 * 
 * Explanation:
 * The positive number 2, 4, 5 maintain their relative positions and -1, -3, -4
 * maintain their relative positions
 */

/*
 * Problem 4
 * Given two sorted arrays nums1 and nums2, return an array that contains the
 * union of these two arrays. The elements in the union must be in ascending
 * order.
 * The union of two arrays is an array where all values are distinct and are
 * present in either the first array, the second array, or both.
 * Example 1:
 * Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
 * 
 * Output: [1, 2, 3, 4, 5, 7]
 * 
 * Explanation:
 * The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from
 * nums2
 * 
 * Example 2:
 * Input: nums1 = [3, 4, 6, 7, 9, 9], nums2 = [1, 5, 7, 8, 8]
 * 
 * Output: [1, 3, 4, 5, 6, 7, 8, 9]
 * 
 * Explanation:
 * The element 7 is common to both, 3, 4, 6, 9 are from nums1 and 1, 5, 8 is
 * from nums2
 */