// Solution: Union-find
// Time complexity: O(n^2)
// Space complexity: O(n)
class Solution {
    public int findCircleNum(int[][] M) {
        int count = M.length;
        int[] fathers = new int[count];
        initialize(fathers);
        // 找到阵营就合并老大哥
        for (int i = 0; i < count; i++) {
            for (int j = 0; j <= i; j++) {
                if (M[i][j] == 1) {
                    union(fathers, i, j);
                }
            }
        }
        
        // ***终极寻找老大哥(注意添加的并不是当前fathers存的值，因为可能这个值还有自己的老大哥)
        HashSet<Integer> unions = new HashSet<>();
        for (int i = 0; i < count; i++) {
            unions.add(find(fathers, i));
        }
        // 确定最终老大哥数量
        return unions.size();
    }
    
    private void initialize(int[] fathers) {
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
    }
    
    private void union(int[] fathers, int a, int b) {
        int rootA = find(fathers, a);
        int rootB = find(fathers, b);
        if (rootA != rootB) {
            fathers[rootA] = rootB;
        }
    }
    
    private int find(int[] fathers, int a) {
        if (fathers[a] == a) {
            return a;
        }
        return fathers[a] = find(fathers, fathers[a]);
    }
}
