class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Add elements to hashset
        # Go over each element in hashset
        # if target - key in hashset, return indices
        # else, add index as value of key
        # O(n) time complexity
        hm = {}
        for i, key in enumerate(nums):
            complement = target - key

            if complement in hm:
                return [hm[complement], i]

            hm[key] = i