class Solution {
    public int searchInsert(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target); 
    }

    private int helper(int[] nums, int start, int end, int target) {
        if (start > end) {
            return start;
        }
        int mid = (end - start) / 2 + start;
        if (nums[mid] == target) {
            return mid;
        } else if (target > nums[mid]) { 
            return helper(nums, mid + 1, end, target);
        } else {
            return helper(nums, start, mid - 1, target);
        }
    }
}