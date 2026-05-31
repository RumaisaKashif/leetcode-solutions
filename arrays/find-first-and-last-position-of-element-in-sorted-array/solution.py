class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # O(logn) is binary search
        # Array input is sorted
        # Record first index seen, last index seen, don't terminate binary search when one value
        # of target has been found
        left = 0 
        right = len(nums) - 1
        lowest = -1
        highest = -1

        def helper(left: int, right: int, lowest: int, highest: int) -> List[int]:
            if left > right:  # base case
                return [lowest, highest]

            mid = left + (right - left) // 2

            if nums[mid] == target:
                # update lowest and highest
                lowest = mid if lowest == -1 else min(lowest, mid)
                highest = mid if highest == -1 else max(highest, mid)
                
                # search both sides
                lowest, highest = helper(left, mid - 1, lowest, highest)
                lowest, highest = helper(mid + 1, right, lowest, highest)

            elif nums[mid] < target:
                lowest, highest = helper(mid + 1, right, lowest, highest)
            else:
                lowest, highest = helper(left, mid - 1, lowest, highest)

            return [lowest, highest]

        return helper(left, right, lowest, highest)