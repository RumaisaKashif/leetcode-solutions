class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            dfs(heights, pacificReachable, r, 0, Integer.MIN_VALUE); 
            dfs(heights, atlanticReachable, r, cols - 1, Integer.MIN_VALUE);
        }

        for (int c = 0; c < cols; c++) {
            dfs(heights, pacificReachable, 0, c, Integer.MIN_VALUE); 
            dfs(heights, atlanticReachable, rows - 1, c, Integer.MIN_VALUE);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacificReachable[r][c] && atlanticReachable[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] reachable, int row, int col, int prevHeight) {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length) return;
        if (reachable[row][col] || heights[row][col] < prevHeight) return;

        reachable[row][col] = true;

        dfs(heights, reachable, row - 1, col, heights[row][col]); // Up
        dfs(heights, reachable, row + 1, col, heights[row][col]); // Down
        dfs(heights, reachable, row, col - 1, heights[row][col]); // Left
        dfs(heights, reachable, row, col + 1, heights[row][col]); // Right
    }
}
