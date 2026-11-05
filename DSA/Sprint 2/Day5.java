import java.util.Arrays;

class Day5 {

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int[] bubbleSort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        for (int i = nums.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

    public static int[] insertionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j - 1] > nums[j]) {
                swap(nums, j - 1, j);
                j--;
            }
        }

        return nums;
    }

    public static int[] merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int index = 0;

        int[] temp = new int[high - low + 1];

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        while (right <= high) {
            temp[index++] = nums[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }

        return nums;
    }

    public static int[] mergeSort1(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low >= high)
            return nums;

        mergeSort1(nums, low, mid);
        mergeSort1(nums, mid + 1, high);
        return merge(nums, low, mid, high);
    }

    public static int[] mergeSort(int[] nums) {
        return mergeSort1(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 5, 4, 4, 1, 1 };
        System.out.println(Arrays.toString(mergeSort(nums)));
    }
}

/*
 * Given an array of integers called nums,sort the array in non-decreasing order
 * using the bubble sort algorithm and return the sorted array.
 * 
 * A sorted array in non-decreasing order is an array where each element is
 * greater than or equal to all preceding elements in the array.
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

/*
 * Given an array of integers called nums, sort the array in non-decreasing
 * order using the insertion sort algorithm and return the sorted array.
 * 
 * A sorted array in non-decreasing order is an array where each element is
 * greater than or equal to all preceding elements in the array.
 * 
 * Example 1:
 * Input: nums = [7, 4, 1, 5, 3]
 * 
 * Output: [1, 3, 4, 5, 7]
 * 
 * Explanation: 1 <= 3 <= 4 <= 5 <= 7.
 * 
 * Thus the array is sorted in non-decreasing order.
 * 
 */

/*
 * Given an array of integers, nums,sort the array in non-decreasing order using
 * the merge sort algorithm. Return the sorted array.
 * 
 * A sorted array in non-decreasing order is one in which each element is either
 * greater than or equal to all the elements to its left in the array.
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