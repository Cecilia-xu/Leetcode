// Solution: BFS(Flood fill)
// Time complexity: O(m * n)
// Space complexity: O(m * n)
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        // matrix is null / empty
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int row = matrix.length, col = matrix[0].length;
        boolean[][] canFlowToP = new boolean[row][col];
        boolean[][] canFlowToA = new boolean[row][col];
        
        Queue<int[]> queue = new LinkedList<>();
        // initialize positions that can flow to Pacific  O(m + n)
        for (int i = 0; i < row; i++) {
            canFlowToP[i][0] = true;
            queue.add(new int[]{i, 0});
        }
        for (int j = 0; j < col; j++) {
            canFlowToP[0][j] = true;
            queue.add(new int[]{0, j});
        }
        
        // check whether a position can flow to Pacific O(m * n)
        bfs(matrix, queue, canFlowToP);
        
        queue.clear();
        // intialize positions that can flow to Atlantic  O(m + n)
        for (int i = 0; i < row; i++) {
            canFlowToA[i][col - 1] = true;
            queue.add(new int[]{i, col - 1});
        }
        for (int j = 0; j < col; j++) {
            canFlowToA[row - 1][j] = true;
            queue.add(new int[]{row - 1, j});
        }
        
        // check whether a positionn can flow to Atlantic
        bfs(matrix, queue, canFlowToA);
        
        // traverse canFlowToP and canFlowToA and find the intersection O(m * n)
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (canFlowToP[i][j] && canFlowToA[i][j]) {
                    List<Integer> coordinate = new ArrayList<>();
                    coordinate.add(i);
                    coordinate.add(j);
                    res.add(coordinate);
                }
            }
        }
        
        return res;
    }
    
    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] canFlow) {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int row = matrix.length, col = matrix[0].length;
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            for (int[] dir : directions) {
                int newx = x + dir[0];
                int newy = y + dir[1];
                if (inArea(newx, newy, row, col) && !canFlow[newx][newy] && matrix[x][y] <= matrix[newx][newy]) {
                    canFlow[newx][newy] = true;
                    queue.add(new int[]{newx, newy});
                }
            }
        }
    }
    
    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
