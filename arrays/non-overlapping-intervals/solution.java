class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int nonOverlappingCount = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            // Current interval overlaps with last interval?
            if (interval[0] >= lastEnd) {
                nonOverlappingCount++;
                lastEnd = interval[1];
            }
        }

        // Total-non-overlapping
        return intervals.length - nonOverlappingCount;
    }
}