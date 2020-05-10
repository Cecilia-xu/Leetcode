// Solution: DP 
// Time complexity: O(n^2)
// Space complexity: O(n^2)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        // corner case: numRows == 0
        if (numRows == 0) {
            return res;
        }
        
        // find each line
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // left most || right most
                if (j == 0) {
                    row.add(1);
                }
                else if (j == i) {
                    row.add(1);
                }
                // normal cases
                else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        
        return res;
    }
}
