// Solution 1: DP (n rows)
// Time complexity: O(n^2)
// Space complexity: O(n^2)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    row.add(1);
                }
                else if (j == i) {
                    row.add(1);
                }
                else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        
        return res.get(rowIndex);        
    }
}
// Solution 2: DP (2 rows)
// Time complexity: O(n^2)
// Space complexity: O(n^2)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
        for (int i = 0; i <= rowIndex; i++) {
            pre = cur;
            cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    cur.add(1);
                }
                else if (j == i) {
                    cur.add(1);
                }
                else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
        }
        
        return cur;        
    }
}
