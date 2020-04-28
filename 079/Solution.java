// Solution: DFS
// Time complexity: O(m * n * 4 ^ word.length()). The number of searching starting points: m * n. For each search, we try
// 4 different directions with word.length() in the worst case. Therefore, the number of leaves in the last level for the
// 4-nary tree is 4^word.length() when doing one searching. -> O(m * n * 4 ^word.length())
// Space complexity: O(word.length())
class Solution {
    public char[][] board;
    public String word;
    public int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        
        if (board.length == 0 || board[0].length == 0 && word.length() == 0) {
            return false;
        }
        
        int row = board.length, col = board[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // In each search, we should not use the same cell for more than once.
                    boolean[][] visited = new boolean[row][col];
                    visited[i][j] = true;
                    if (dfs(i, j, 1, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int x, int y, int offset, boolean[][] visited) {
        if (offset == word.length()) {
            return true;
        }
        for (int[] dir : directions) {
            int newx = x + dir[0];
            int newy = y + dir[1];
            if (inArea(newx,newy) && !visited[newx][newy] && board[newx][newy] == word.charAt(offset)) {
                visited[newx][newy] = true;
                // searching start at the next character in word
                if(dfs(newx, newy, offset + 1, visited)) {
                    return true;
                }
                // The searching in the last round fails. BackTracking for other solution. Recover visited.
                visited[newx][newy] = false; //***********DFS: Backtracking (Recover the state! DO NOT FORGET!!)
            }
        }
        return false;
    }
                   
    private boolean inArea(int x, int y) {
        int row = board.length, col = board[0].length;
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
