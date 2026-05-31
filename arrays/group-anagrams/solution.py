class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # sort each word-> n words, O(nklogk)
        # use sorted word as key for grouping anagrams in hashmap
        hm = {}
        for word in strs:
            sorted_word = ''.join(sorted(word))
            # note: we can use hm.get(sorted_word, []) + [word] but this creates a new list [word] every time = overhead
            if sorted_word not in hm:
                hm[sorted_word] = []
            hm[sorted_word].append(word)

        return list(hm.values())



            


