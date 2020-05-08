// Solution: BFS(flood fill)
// Time complexity: O(m * n)
// Space complexity: O(m * n)
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        int row = rooms.length, col = rooms[0].length;
        // initial state
        int countGate = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    countGate++;
                }
            }
        }
        // no gate exists
        if (countGate == 0) {
            return;
        }
        // flood fill
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // detect neighbour of nodes that can be arrived in the same steps
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                // find neighbours of one node
                for (int[] dir : directions) {
                    int newx = dir[0] + pos[0];
                    int newy = dir[1] + pos[1];
                    if (inArea(newx, newy, row, col) && rooms[newx][newy] == Integer.MAX_VALUE) {
                        rooms[newx][newy] = step + 1;
                        queue.add(new int[]{newx, newy});
                    }
                }
            }
            step++;
        }
    }
    
    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
