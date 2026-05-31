class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hm = {}
        # map element to frequency, time and space o(n)
        for n in nums:
            hm[n] = hm.get(n, 0) + 1
        # map frequency to elements - another hashmap
        fm = {}
        for key, value in hm.items():
            if value not in fm:
                fm[value] = []
            fm[value].append(key)
        
        result = [] # O(n) space, O(n) time
        for i in range(len(nums), 0, -1):
            length = len(result)
            if length == k:
                break
            if i in fm:
                # interesting leetcode bug: accepts result.extend(fm[i]) in sol
                result.extend(fm[i][:k - length])
        return result




        
            
        