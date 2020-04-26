// My Solution: dynamic programming (sequence-type)
// Time complexity: O(n^2)
// Space complexity: O(n^2)
// Note: valid[j][i] means whether the substring from j to i contains in the dict.
// update valid[0][i]== true if valid[0][j - 1] == true && valid [j][i] == true
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0) {
            return false;
        }
        Set<String> dict = new HashSet<String>();
        for (String word : wordDict) {
            dict.add(word);
        }
        boolean[][] valid = new boolean[s.length()][s.length()];
        // initialization
        for (int i = 0; i < valid.length; i++) {
            Arrays.fill(valid[i], false);
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dict.contains(s.substring(j, i + 1))) {
                    valid[j][i] = true;
                    if (j > 0 && valid[0][j - 1]) {
                        valid[0][i] = true;
                    }
                }
            }
        }
        return valid[0][s.length() - 1];
    }
}

// My solution: dynamic programming with space optimization
// Time complexity: O(n^2)
// Space complexity: O(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0) {
            return false;
        }
        Set<String> dict = new HashSet<String>();
        for (String word : wordDict) {
            dict.add(word);
        }
        boolean[] valid = new boolean[s.length()];
        // initialization
        for (int i = 0; i < valid.length; i++) {
            Arrays.fill(valid, false);
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dict.contains(s.substring(j, i + 1))) {
                    if (j == 0) {
                        valid[i] = true;
                    }
                    else if (valid[j - 1]) {
                        valid[i] = true;
                    }
                }
            }
        }
        return valid[s.length() - 1];
    }
}
