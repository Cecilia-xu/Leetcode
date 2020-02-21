// Solution 1: DFS
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] dMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] output = new char[digits.length()];
        ArrayList<String> ans = new ArrayList<>();
        if (digits.length() != 0) {
            dfs(digits, dMap, 0, output, ans);
        }
        return ans;
    }
    
    private void dfs(String digits, String[] dMap, int level, char[] output, ArrayList<String> ans) {
        // base case
        if (level == digits.length()) {
            if (level > 0) {
                ans.add(new String(output));
                return;
            }
        }
        
        // get all cases for each digit
        String s = dMap[Character.getNumericValue(digits.charAt(level))];
        
        // add different letters to the responding output position
        for (int i = 0; i < s.length(); i++) {
            output[level] = s.charAt(i);
            dfs(digits, dMap, level + 1, output, ans);
        }
    }
}
