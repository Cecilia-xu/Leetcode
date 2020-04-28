// Solution 1: BFS
// Time complexity: O(m * n)
// Space complexity: O(m * n)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length  == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int area = 1;
                    while (!queue.isEmpty()) {
                        int[] node = queue.poll();
                        for (int[] dir : directions) {
                            int newx = node[0] + dir[0];
                            int newy = node[1] + dir[1];
                            if (inArea(newx, newy, row, col) && !visited[newx][newy] && grid[newx][newy] == 1) {
                                area += 1;
                                queue.offer(new int[]{newx, newy});
                                visited[newx][newy] = true;
                            }
                        }
                    }
                    res = Math.max(area, res);
                }
            }
        }
        return res;
    }
    
    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}

// Solution 2: DFS (use visited array to record the state of visits)
// Time complexity: O(m * n)
// Space complexity: O(m * n)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length  == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    int area = dfs(grid, visited, directions, i, j);
                    res = Math.max(res, area);
                }
             }
        }
        return res;
    }
    
    private int dfs(int[][] grid, boolean[][] visited, int[][] directions, int x, int y) {
        int row = grid.length, col = grid[0].length;
        int count = 1;
        for (int[] dir : directions) {
            int newx = dir[0] + x;
            int newy = dir[1] + y;
            if (inArea(newx, newy, row, col) && !visited[newx][newy] && grid[newx][newy] == 1) {
                visited[newx][newy] = true;
                count += dfs(grid, visited, directions, newx, newy);
            }
        }
        return count;
    }
    
    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}

// Solution 3: DFS (in-place method to record the state of visits)
// Time complexity: O(m * n) For calling bfs each time, the time complexity would be O(1). In the worst case, we call dfs
// m * n times -> recursion: O(m * n) 
// Space complexity: O(???) 
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length  == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    int area = dfs(grid, directions, i, j);
                    res = Math.max(res, area);
                }
             }
        }
        return res;
    }
    
    private int dfs(int[][] grid, int[][] directions, int x, int y) {
        int row = grid.length, col = grid[0].length;
        int count = 1;
        for (int[] dir : directions) {
            int newx = dir[0] + x;
            int newy = dir[1] + y;
            if (inArea(newx, newy, row, col) && grid[newx][newy] == 1) {
                grid[newx][newy] = -1;
                count += dfs(grid, directions, newx, newy);
            }
        }
        return count;
    }
    
    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
