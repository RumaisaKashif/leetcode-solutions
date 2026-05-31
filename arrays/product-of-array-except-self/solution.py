class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # get left product and store in array
        # get right product and store in array
        # multiply both arrays
        # place at answer[i]
        # Space and Time: O(n)
        # Space can be O(1) [defintion of O(1) excludes answer array] if answer array reused

        left_prod = [1] * len(nums) # arrays must be same size as nums
        right_prod = [1] * len(nums)
        answer = [1] * len(nums)

        # left mutliplication
        left = 1
        for i, n in enumerate(nums):
                left_prod[i] = left
                left = n * left

        # right mutliplication
        right = 1
        for i in range(len(nums) - 1, -1, -1):
            right_prod[i] = right
            right = nums[i] * right

        # multiply both arrays
        for i in range(0, len(nums)):
            answer[i] = left_prod[i] * right_prod[i]

        return answer


            