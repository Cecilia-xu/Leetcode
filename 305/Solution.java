// Solution 1: union find
// Note: this question can be considered to find how many sets in the union find class.
// Time: O(m * n) initialize union find class + O(klog*k) union find operations
// Space: O(k) result arraylist + O(m * n) father[] array in union find + O(m * n) island[][] array
class Solution {
    public class UnionFind {
        public int[] father; 
        public UnionFind(int m, int n) {
            father = new int[m * n];
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
            }
        }
        public int find(int x) {
            if (father[x] == x) {
                return x;
            }
            return father[x] = find(father[x]);
        }
        
        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                father[rootA] = rootB;
            }
        }
    }
    
    public int convertId(int x, int y, int n) {
        return x * n + y;
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (positions == null || positions.length == 0) {
            return result;
        }
        int[][] island = new int[m][n];
        UnionFind uf = new UnionFind(m, n);
        int count = 0;
        for (int[] pos : positions) {
            int x = pos[0];
            int y = pos[1];
            if (island[x][y] != 1) {
                island[x][y] = 1;
                count++;
                count = searchNeighbor(x, y, island, count, uf);
            }
            result.add(count);
        }
        return result;
    }
    
    public int searchNeighbor(int x, int y, int[][] island, int count, UnionFind uf) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = island.length, n = island[0].length;
        for (int[] dir : directions) {
            int newx = dir[0] + x;
            int newy = dir[1] + y;
            if (newx >= 0 && newx < m && newy >= 0 && newy < n && island[newx][newy] == 1) {
                int newid = convertId(newx, newy, n);
                int id = convertId(x, y, n);
                // check connectivity first: when they have the same father, which means these two cells have been already connected
                int r1 = uf.find(newid);
                int r2 = uf.find(id);
                if (r1 != r2) {
                    count--;
                    // Union? When two neighbor cells are both 1 and they have not been connected
                    uf.union(r1, r2);
                }
            }
        }
        return count;
    }
}
