class Solution:
    def maxRepeating(self, sequence: str, word: str) -> int:
        temp = word
        k = 0
        while temp in sequence:
            temp += word
            k += 1
        return k