import java.util.Arrays;

public class Day8 {

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int pivotFunc(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j = high;

        while (i < j) {

            while (nums[i] <= pivot && i <= high - 1)
                i++;
            while (nums[j] > pivot && j >= low + 1)
                j++;

            if (i < j)
                swap(nums, i, j);
        }
        swap(nums, low, j);

        return j;

    }

    public static void quickSort1(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = pivotFunc(nums, low, high);
            quickSort1(nums, low, pivotIndex - 1);
            quickSort1(nums, pivotIndex + 1, high);
        }
    }

    public static int[] quickSort(int[] nums) {
        quickSort1(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 4, 1, 5, 3 };
        System.out.println(Arrays.toString(quickSort(arr)));
    }
}

/*
 * Given an array of integers called nums, sort the array in non-decreasing
 * order using the quick sort algorithm and return the sorted array.
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