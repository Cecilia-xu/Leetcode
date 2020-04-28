// Solution 1: BFS
// Time complexity: O(m * n) m - row, n - column
// Space complexity: O(m * n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length, col = image[0].length;
       
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        
        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            for (int[] dir : directions) {
                int newx = dir[0] + coord[0];
                int newy = dir[1] + coord[1];
                int[] newcoord = new int[]{newx, newy};
                if (inArea(newx, newy, row, col) && !visited[newx][newy] && image[newx][newy] == oldColor) {
                    image[newx][newy] = newColor;
                    queue.offer(newcoord);
                    visited[newx][newy] = true;
                }
            }
        }
        return image;
    }
    
    private boolean inArea(int newx,int newy,int row,int col) {
        return newx >= 0 && newx < row && newy >= 0 && newy < col;
    }
}
