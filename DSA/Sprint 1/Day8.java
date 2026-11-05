import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day8 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        // Number of rows
        int n = matrix.length;

        // Number of columns
        int m = matrix[0].length;

        // Initialize pointers for traversal
        int top = 0, left = 0;
        int bottom = n - 1, right = m - 1;

        // Traverse the matrix in spiral order
        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; ++i) {
                ans.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom; ++i) {
                ans.add(matrix[i][right]);
            }
            right--;

            // Traverse from right to left
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        // Return the ans
        return ans;
    }

    public static int[] intersectionArray(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();

        int[] vis = new int[nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && vis[j] == 0) {
                    ans.add(nums1[i]);
                    vis[j] = 1;
                    break;
                }

                if (nums2[j] > nums1[i])
                    break;
            }
        }

        int[] arr = new int[ans.size()];
        int index = 0;
        for (int i : ans) {
            arr[index] = i;
            index++;
        }

        return arr;
    }

    public List<Integer> majorityElementTwo(int[] nums) {
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

    public static int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                if (ans.isEmpty() || ans.get(ans.size() - 1) != nums1[i]) {
                    ans.add(nums1[i]);
                }
                i++;
            } else {
                if (ans.isEmpty() || ans.get(ans.size() - 1) != nums2[j]) {
                    ans.add(nums2[j]);
                }
                j++;
            }
        }

        while (i < n1) {
            if (ans.isEmpty() || ans.get(ans.size() - 1) != nums1[i]) {
                ans.add(nums1[i]);
            }
            i++;
        }

        while (j < n2) {
            if (ans.isEmpty() || ans.get(ans.size() - 1) != nums2[j]) {
                ans.add(nums2[j]);
            }
            j++;
        }

        int[] arr = new int[ans.size()];
        int index = 0;
        for (int x : ans) {
            arr[index] = x;
            index++;
        }

        return arr;
    }

    public static void main(String[] args) {
        // int[][] mat = {
        // { 1, 2, 3, 4 },
        // { 5, 6, 7, 8 },
        // { 9, 10, 11, 12 },
        // { 13, 14, 15, 16 }
        // };
        // Day8 finder = new Day8();

        // // Get spiral order using class method
        // List<Integer> ans = finder.spiralOrder(mat);

        // System.out.print("Elements in spiral order are: ");
        // for (int i = 0; i < ans.size(); ++i) {
        // System.out.print(ans.get(i) + " ");
        // }
        // System.out.println();

        int[] nums1 = { 1, 2, 3, 4, 5 };
        int[] nums2 = { 1, 2, 7 };

        System.out.println(Arrays.toString(unionArray(nums1, nums2)));
    }
}

/*
 * Given an M * N matrix, print the elements in a clockwise spiral manner.
 * 
 * Return an array with the elements in the order of their appearance when
 * printed in a spiral manner.
 * 
 * Example 1:
 * Input: matrix = [[1, 2, 3], [4 ,5 ,6], [7, 8, 9]]
 * 
 * Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
 * 
 * Explanation:
 * 
 * The elements in the spiral order are 1, 2, 3 -> 6, 9 -> 8, 7 -> 4, 5
 * 
 * Example 2:
 * Input: matrix = [[1, 2, 3, 4], [5, 6, 7, 8]]
 * 
 * Output: [1, 2, 3, 4, 8, 7, 6, 5]
 * 
 * Explanation:
 * 
 * The elements in the spiral order are 1, 2, 3, 4 -> 8, 7, 6, 5
 */

/*
 * Given two sorted arrays, nums1 and nums2, return an array containing the
 * intersection of these two arrays. Each element in the result must appear as
 * many times as it appears in both arrays; that is, if an element appears x
 * times in nums1 and y times in nums2, it should appear min(x, y) times in the
 * result.
 * 
 * The intersection of two arrays is an array where all values are present in
 * both arrays.
 * 
 * Example 1:
 * Input: nums1 = [1, 2, 2, 3, 5], nums2 = [1, 2, 7]
 * 
 * Output: [1, 2]
 * 
 * Explanation:
 * 
 * The elements 1, 2 are the only elements present in both nums1 and nums2
 * 
 * Example 2:
 * Input: nums1 = [1, 2, 2, 3, 3, 3], nums2 = [2, 3, 3, 4, 5, 7]
 * 
 * Output: [2, 3, 3]
 * 
 * Explanation:
 * 
 * The element 2 appears in both arrays only one time.
 * 
 * The element 3 appears in both arrays two times so we add element 3 equal to
 * its number of occurrences.
 */

/*
 * Given two sorted arrays nums1 and nums2, return an array that contains the
 * union of these two arrays. The elements in the union must be in ascending
 * order.
 * 
 * The union of two arrays is an array where all values are distinct and are
 * present in either the first array, the second array, or both.
 * 
 * Example 1:
 * Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
 * 
 * Output: [1, 2, 3, 4, 5, 7]
 * 
 * Explanation:
 * 
 * The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from
 * nums2
 * 
 * Example 2:
 * Input: nums1 = [3, 4, 6, 7, 9, 9], nums2 = [1, 5, 7, 8, 8]
 * 
 * Output: [1, 3, 4, 5, 6, 7, 8, 9]
 * 
 * Explanation:
 * 
 * The element 7 is common to both, 3, 4, 6, 9 are from nums1 and 1, 5, 8 is
 * from nums2
 */