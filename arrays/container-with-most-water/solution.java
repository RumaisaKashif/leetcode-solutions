class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int i = 0;
        int j = len - 1;
        // int maxWaterWidth = 0;
        int maxVol = 0;
        while (i < j) {
            maxVol = Math.max(maxVol, Math.min(height[i], height[j]) * (j - i));

            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxVol;   
    }
}