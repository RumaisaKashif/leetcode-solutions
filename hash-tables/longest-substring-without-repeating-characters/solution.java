class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        // Left pointer
        int start = 0;
        HashSet<Character> charsPresent = new HashSet<>();

        // Sliding window approach, end = right pointer
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // While current char is already present in the hashset, reduce the window
            while (charsPresent.contains(currentChar)) {
                charsPresent.remove(s.charAt(start)); // Remove leftmost char
                start++; // Move start pointer forward
            }

            // Add current char
            charsPresent.add(currentChar);

            // Update output
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
