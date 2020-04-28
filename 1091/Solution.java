// Solution: BFS
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // Initial state and termination state is invalid
        int row = grid.length, col = grid[0].length;
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        // Only one node*****(DO NOT FORGET THIS CORNER CASE!)
        if (row == 1 && col == 1) {
            return 1;
        }
                                             
        // BFS
        int[][] directions = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, 
                                         {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = -1;
        int pathLength = 1;
        while (!queue.isEmpty()) {
            // the size of all nodes added in the previous step
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // find the node need to be expaned
                int[] node = queue.poll();
                // generate the node's successors in 8 directions
                for (int[] dir : directions) {
                    int newx = dir[0] + node[0];
                    int newy = dir[1] + node[1];
                    if (inArea(newx, newy, row, col) && grid[newx][newy] == 0) {
                        queue.offer(new int[]{newx, newy});
                        grid[newx][newy] = -1;
                        if (newx == row - 1 && newy == col - 1) {
                            return pathLength + 1;
                        }
                    }
                }
            }
            // finish visiting nodes in the same pathLength and update pathLength
            pathLength++;
        }
        return -1;
    }
    
    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
