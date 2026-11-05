import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    // Merge sort function
    private static int mergeSort(int[] nums, int low, int high) {
        if (low >= high)
            return 0;

        int mid = (low + high) / 2;
        int cnt = 0;

        cnt += mergeSort(nums, low, mid);
        cnt += mergeSort(nums, mid + 1, high);
        cnt += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

        return cnt;
    }

    // Count reverse pairs
    private static int countPairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1, cnt = 0;

        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) nums[i] > 2L * nums[right]) {
                right++;
            }
            cnt += (right - (mid + 1));
        }

        return cnt;
    }

    // Merge two sorted halves
    private static void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid)
            temp.add(nums[left++]);
        while (right <= high)
            temp.add(nums[right++]);

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    public static int maxProduct(int[] nums) {
        int pre = 1, suf = 1;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (pre == 0)
                pre = 1;
            if (suf == 0)
                suf = 1;

            pre = pre * nums[i];
            suf = suf * nums[n - i - 1];

            ans = Math.max(ans, Math.max(suf, pre));
        }

        return ans;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[n + m];
        int left = m - 1;
        int right = 0;
        int index = 0;

        while (left >= m && right < n) {
            if (nums1[left] <= nums2[right]) {
                nums3[index] = nums1[left];
                index++;
                left++;
            } else {
                nums3[index] = nums2[right];
                index++;
                right++;
            }
        }

        while (left < m) {
            nums3[index++] = nums1[left++];
        }
        while (right < n) {
            nums3[index++] = nums2[right++];
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = nums3[i];
        }

    }

    public static int[] selectionSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 4, 1, 5, 3 };
        System.out.println(Arrays.toString(selectionSort(nums)));
    }
}

/*
 * Given an integer array nums. Return the number of reverse pairs in the array.
 * 
 * An index pair (i, j) is called a reverse pair if:
 * 
 * 0 <= i < j < nums.length
 * nums[i] > 2 * nums[j]
 * Example 1:
 * Input: nums = [6, 4, 1, 2, 7]
 * 
 * Output: 3
 * 
 * Explanation:
 * 
 * The reverse pairs are:
 * 
 * (0, 2) : nums[0] = 6, nums[2] = 1, 6 > 2 * 1
 * 
 * (0, 3) : nums[0] = 6, nums[3] = 2, 6 > 2 * 2
 * 
 * (1, 2) : nums[1] = 4, nums[2] = 1, 4 > 2 * 1
 */

/*
 * Given an integer array nums. Find the subarray with the largest product, and
 * return the product of the elements present in that subarray.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * Example 1:
 * Input: nums = [4, 5, 3, 7, 1, 2]
 * 
 * Output: 840
 * 
 * Explanation:
 * 
 * The largest product is given by the whole array itself
 */

/*
 * Given two integer arrays nums1 and nums2. Both arrays are sorted in
 * non-decreasing order.
 * 
 * Merge both the arrays into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should be stored inside the array nums1 and it should
 * be done in-place.
 * nums1 has a length of m + n, where the first m elements denote the elements
 * of nums1 and rest are 0s.
 * nums2 has a length of n.
 * Example 1:
 * Input: nums1 = [-5, -2, 4, 5], nums2 = [-3, 1, 8]
 * 
 * Output: [-5, -3, -2, 1, 4, 5, 8]
 * 
 * Explanation:
 * 
 * The merged array is: [-5, -3, -2, 1, 4, 5, 8], where [-5, -2, 4, 5] are from
 * nums1 and [-3, 1, 8] are from nums2
 */

/*
 * Given an array of integers nums, sort the array in non-decreasing order using
 * the selection sort algorithm and return the sorted array.
 * 
 * A sorted array in non-decreasing order is an array where each element is
 * greater than or equal to all previous elements in the array.
 * 
 * Example 1:
 * Input: nums = [7, 4, 1, 5, 3]
 * 
 * Output: [1, 3, 4, 5, 7]
 * 
 * Explanation: 1 <= 3 <= 4 <= 5 <= 7.
 * 
 * Thus the array is sorted in non-decreasing order.
 */