// Solution: BFS 
// Time complexity: O(m * n) m = row, n = col
// Space complexity: O(m * n)
// Note: The grid is just a state. Our initial state is the initial grid. 
// The termination state is the state when there is nofresh oranges.
// We do not need HashSet in this question because the value in each cell can represent the state. Not visited - 1, Visited- 2.
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
       
        // Initial state
        Queue<int[]> queue = new LinkedList<>();
        int countFresh = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    countFresh++;
                }
                else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        // No fresh oranges
        if (countFresh == 0) {
            return 0;
        }
        
        // rotting oranges
        int minute = 0;
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            // get the size of rotten oranges at the previous minute 
            int size = queue.size();
            // current minute
            minute++;
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                for (int[] dir : directions) {
                    int newx = rotten[0] + dir[0];
                    int newy = rotten[1] + dir[1];
                    if (inArea(newx, newy, grid) && grid[newx][newy] == 1) {
                        grid[newx][newy] = 2;
                        countFresh--;
                        if (countFresh == 0) {
                            return minute;
                        }
                        queue.offer(new int[]{newx, newy});
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean inArea(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
