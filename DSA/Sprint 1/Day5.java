import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day5 {
    public static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = matrix[m - 1 - j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = ans[i][j];
            }
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int more = target - num;
            if (map.containsKey(more)) {
                return new int[] { map.get(more), i };
            }

            map.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum < 0) {
                    k--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);

                    // Skip duplicates
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, -2, 0, 3, -3, 5 };
        System.out.println(threeSum(arr));
    }
}

/*
 * Problem: 1
 * Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.
 * The rotation must be done in place, meaning the input 2D matrix must be
 * modified directly.
 * 
 * Example 1:
 * Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
 * Output: matrix = [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
 * 
 */

/*
 * Problem: 2
 * 3 Sum
 * Core
 * Given an integer array nums. Return all triplets such that:
 * i != j, i != k, and j != k
 * nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets. One element
 * can be a part of multiple triplets. The output and the triplets can be
 * returned in any order.
 * 
 * Example 1:
 * Input: nums = [2, -2, 0, 3, -3, 5]
 * 
 * Output: [[-2, 0, 2], [-3, -2, 5], [-3, 0, 3]]
 * 
 * Explanation:
 * 
 * nums[1] + nums[2] + nums[0] = 0
 * 
 * nums[4] + nums[1] + nums[5] = 0
 * 
 * nums[4] + nums[2] + nums[3] = 0
 */