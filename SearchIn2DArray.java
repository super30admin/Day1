
//Time Complexity : O(log(mn))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES. Its little inclear why  I am using mid/n or mid% n for the row and col selection.

//Approach.
//since the question mentions of solving in log mn, its a hint to use binary search.
// TO optimize it, trying to find total number of elements  by doing m*n; and then findng the middle.
// then use the row/ col formulat o find the row/ col and perform binary search.


public class SearchIn2DArray {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix == null)
            return false;

        // find rows and coloums
        // rows
        int m = matrix.length;
        // coloums
        int n = matrix[0].length;
        // Find low and high
        int low = 0;
        int high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
