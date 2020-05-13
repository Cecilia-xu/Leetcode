// My solution: bfs
// Time complexity: O(m * n)
// Space complexity: O(m * n)
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        // search all 'O' that are connected to 'O' on the border
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (onBorder(i, j, row, col) && board[i][j] == 'O') {
                    bfs(board, i, j, visited);
                }
            }
        }
        
        // change all 'O's that are not connected to 'O' on the border
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private boolean onBorder(int x, int y, int row, int col) {
        return x == 0 || x == row - 1 || y == 0 || y == col - 1;
    }
    
    private void bfs(char[][] board, int x, int y, boolean[][] visited) {
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true; 
        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            for (int[] dir : directions) {
                int newx = dir[0] + coord[0];
                int newy = dir[1] + coord[1];
                if (inArea(newx, newy, board.length, board[0].length) && board[newx][newy] == 'O' && !visited[newx][newy]) {
                    queue.add(new int[]{newx, newy});
                    visited[newx][newy] = true;
                }
            }
        }
    }
    
    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && x < row && y > 0 && y < col;
    }
}
