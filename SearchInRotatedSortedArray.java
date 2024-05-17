//Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No.


//Aproach
//taking advatage of the fact at any given point one side of the arry is sorted.
// And even part of unsorted array is sorted. Hence the binary search
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null)
            return -1;
        int n = nums.length;

        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;// prevent integer overflow
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }

        }
        return -1;

    }
}
