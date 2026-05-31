class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        #  Option 1: Space = O(1) in place sorting, Time = O(nlogn)
        # if len(s) != len(t):
        #     return False
        # else:
        #     return sorted(s) == sorted(t)

        # Option 2: Time = O(n), Space = O(n)
        from collections import Counter
        return Counter(s) == Counter(t)