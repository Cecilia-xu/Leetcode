class Solution {
    public int[][] grid;
    public int[][] distance;
    public int[][] reachesCount;
    public int shortestDistance(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        
        // initialization
        this.grid = grid;
        this.distance = new int[row][col];
        this.reachesCount = new int[row][col];
        int buildingCount = 0;
        
        //bfs
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    buildingCount += 1;
                    Queue<int[]> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[row][col];
                    bfs(i, j, queue, visited);
                }
            }
        }
        
        // find answers
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reachesCount[i][j] == buildingCount) {
                    result = Math.min(result, distance[i][j]);
                }
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private void bfs(int x, int y, Queue<int[]> queue, boolean[][] visited) {
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int step = 0;
        
        int[] start = new int[]{x, y};
        queue.add(start);
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            step += 1;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                
                for (int[] dir : directions) {
                    int newx = cur[0] + dir[0];
                    int newy = cur[1] + dir[1];
                    int[] coord = new int[]{newx, newy};
                    if (inArea(newx, newy) && grid[newx][newy] == 0 && !visited[newx][newy]) {
                        queue.add(coord);
                        visited[newx][newy] = true;
                        distance[newx][newy] += step;
                        reachesCount[newx][newy] += 1;
                    }
                }
                
            }
        }
    }
    
    private boolean inArea(int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
