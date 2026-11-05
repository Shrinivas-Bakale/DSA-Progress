import java.util.ArrayList;
import java.util.List;

public class Day9 {

    public static int nCr(int n, int r) {
        if (r > n - r)
            r = n - r;
        if (r == 1)
            return n;

        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }

    public static int pascalTriangleI(int r, int c) {
        return nCr(c - 1, r - 1);
    }

    public int[] pascalTriangleII(int r) {
        int[] ans = new int[r];

        ans[0] = 1;

        for (int i = 1; i < r; i++) {
            ans[i] = (ans[i - 1] * (r - i)) / i;
        }

        return ans;
    }

    private List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();

        // Inserting the 1st element
        ansRow.add(1);

        // Calculate the rest of the elements
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }

        return ansRow; // Return the computed row
    }

    public List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        // Compute the entire Pascal's Triangle
        for (int row = 1; row <= n; row++) {
            pascalTriangle.add(generateRow(row));
        }

        // return the pascalTriangle
        return pascalTriangle;
    }

    public static void main(String[] args) {
        System.out.println(pascalTriangleI(4, 2));
    }
}

/*
 * Given two integers r and c, return the value at the rth row and cth column
 * (1-indexed) in a Pascal's Triangle.
 * 
 * In Pascal's triangle:
 * 
 * The first row contains a single element 1.
 * Each row has one more element than the previous row.
 * Every row starts and ends with 1.
 * For all interior elements (i.e., not at the ends), the value at position (r,
 * c) is computed as the sum of the two elements directly above it from the
 * previous row:
 * 
 * Pascal[r][c]=Pascal[r−1][c−1]+Pascal[r−1][c]
 * where indexing is 1-based
 * Example 1:
 * Input: r = 4, c = 2
 * 
 * Output: 3
 * 
 * Explanation:
 * 
 * The Pascal's Triangle is as follows:
 * 
 * 1
 * 
 * 1 1
 * 
 * 1 2 1
 * 
 * 1 3 3 1
 * 
 * ....
 * 
 * Thus, value at row 4 and column 2 = 3
 * 
 * Example 2:
 * Input: r = 5, c = 3
 * 
 * Output: 6
 * 
 * Explanation:
 * 
 * The Pascal's Triangle is as follows:
 * 
 * 1
 * 
 * 1 1
 * 
 * 1 2 1
 * 
 * 1 3 3 1
 * 
 * 1 4 6 4 1
 * 
 * ....
 * 
 * Thus, value at row 5 and column 3 = 6
 */