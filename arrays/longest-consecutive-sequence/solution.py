class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        hm = {}
        for num in nums:
            hm[num] = 0
        hs = set()

        seq_len = 0
        for key in hm:
            if key in hs:
                continue
            hs.add(key)

            k = key - 1
            while k in hm:
                hs.add(k)
                hm[key] = hm[key] + 1
                k = k - 1

            k = key + 1
            while k in hm:
                hs.add(k)
                hm[key] = hm[key] + 1
                k = k + 1

        max_val = 0
        for _, val in hm.items():
            max_val = max(max_val, val + 1)
        return max_val


