class Solution {
    public int findMin(int[] nums) {
        return findMinHelper(nums, 0, nums.length - 1);
    }

    private int findMinHelper(int[] nums, int begin, int end) { 
        if (begin == end) { 
            return nums[begin];
        }

        // If nums is already sorted
        if (nums[begin] < nums[end]) {
            return nums[begin];
        }

        int mid = begin + (end - begin)/2;
        if (nums[end] < nums[mid]) {
            // Min on right
            return findMinHelper(nums, mid + 1, end);
        } else {
            // Min on left of mid or mid
            return findMinHelper(nums, begin, mid);
        }
    }
}