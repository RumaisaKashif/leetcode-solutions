class Solution {
    // Directions to traverse
    private static final int[] XCHANGE = {-1, 1, 0, 0};
    private static final int[] YCHANGE = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null) return 0;

        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Increment island count when '1' encountered and traverse neighbours
                if (grid[i][j] == '1') {
                    numIslands++;
                    // Mark as visited (water)
                    grid[i][j] = '0';
                    // Use BFS to traverse connected component
                    bfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private void bfs(char[][] grid, int posX, int posY) {
        // Initialise BFS FIFO Queue
        Queue<int[]> bfsQueue = new LinkedList<>();
        // Add current cell's coordinated to bfsQueue
        bfsQueue.add(new int[] {posX, posY});

        // Traverse neighbours (up/down/left/right)
        while(!bfsQueue.isEmpty()) {
            // Remove element at the front
            int[] curr = bfsQueue.poll();
            // Extract x coordinate
            int x = curr[0];
            // Extract y coordinate
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                // Change cell coordinates (move to neighbour e.g. curr + (1,0) -> up)
                int neighbourX = x + XCHANGE[i];
                int neighbourY = y + YCHANGE[i];    

                // Check for out of bounds error while searching for land
                if (neighbourX >= 0 && neighbourX < grid.length 
                && neighbourY >= 0 && neighbourY < grid[0].length
                && grid[neighbourX][neighbourY] == '1') {
                    // Add land neighbout to queue
                    bfsQueue.add(new int[] {neighbourX, neighbourY});
                    // Mark as visited
                    grid[neighbourX][neighbourY] = '0';
                }
            }
        }
    }
}