class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxFreq = 0;
        int start = 0;
        HashMap<Character, Integer> count = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            // Increment frequency of character in hashmap
            count.put(c, count.getOrDefault(c, 0) + 1);
            // Update max frequency of any char encountered in the window
            maxFreq = Math.max(maxFreq, count.get(c));
            
            // If the number of chars that can be replaced exceed k: invalid window
            if ((end - start + 1) - maxFreq > k) {
                char leftChar = s.charAt(start);
                // Decrement the freq of the leftmost char
                count.put(leftChar, count.get(leftChar) - 1);
                // Move left pointer forward
                start++;
            }

            // Update maxlength
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
