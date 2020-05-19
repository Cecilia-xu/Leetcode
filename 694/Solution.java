// Solution: DFS
// Time complexity: O(m * n)
// Space complexity: O(m * n)
// How to solve this problem? Use a string to record the path and this path should be unique.Duplicate path will be deduplicated
// by hashset.
class Solution {
    public int numDistinctIslands(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        // *optional - can use grid to represent the state of visited
        boolean[][] visited = new boolean[row][col];
        // add all unique paths
        HashSet<String> patterns = new HashSet<>();
        // set directions and their corresponding character
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        char[] move = new char[]{'D', 'U', 'R', 'L'};
        // dfs until all elements in the same island have been visited
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    // create a stringbuilder to construct the path
                    StringBuilder res = new StringBuilder();
                    visited[i][j] = true;
                    dfs(grid, visited, i, j, res, directions, move);
                    // add the path
                    patterns.add(res.toString());
                }
            }
        }
        return patterns.size();
    }

    private void dfs(int[][] grid, boolean[][] visited, int x, int y, StringBuilder res, int[][] directions, char[] move) {
        for (int i = 0; i < directions.length; i++) {
            int newx = directions[i][0] + x;
            int newy = directions[i][1] + y;
            char m = move[i];
            if (inArea(newx, newy, grid.length, grid[0].length) && grid[newx][newy] == 1 && !visited[newx][newy]) {
                res.append(m);
                visited[newx][newy] = true;
                dfs(grid, visited, newx, newy, res, directions, move);
            }
        }
        res.append('B');
    }

    private boolean inArea(int x, int y, int row, int col ) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

}
