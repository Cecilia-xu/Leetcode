// Solution: DFS (find all possible results)
// Related question: No.132
// Time complexity: O(n * 2^n)
// Space complexity: O(n)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        boolean[][] isPali = isValidPali(s.toCharArray());
        findPartition(result, new ArrayList<String>(), s, 0, isPali);
        return result;
    }
    
    private void findPartition(List<List<String>> result, List<String> solu, String s, int pos, boolean[][] isPali) {
        if (pos == s.length()) {
            result.add(new ArrayList<String>(solu));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (isPali[pos][i]) {
                solu.add(s.substring(pos, i + 1));
                findPartition(result, solu, s, i + 1, isPali);
                solu.remove(solu.size() - 1);
            }
        }        
    }
    
    // each element represents whether a substring from start to end is a palidrome
    public boolean[][] isValidPali(char[] s) {
        boolean[][] validPali = new boolean[s.length][s.length];
        for (int i = 0; i < validPali.length; i++) {
            Arrays.fill(validPali[i], false);
        }
        for (int i = 0; i < s.length; i++) {
            // case 1: the palindrome length is oddd, s[i] is the middle element
            int start = i, end = i;
            while (start >= 0 && end < s.length && s[start] == s[end]) {
                validPali[start][end] = true;
                start--;
                end++;
            }
            // case 2: the palindrome length is even, s[i] and s[i - 1] is middle elements
            start = i - 1;
            end = i;
            while (start >= 0 && end < s.length && s[start] == s[end]) {
                validPali[start][end] = true;
                start--;
                end++;
            }
        }
        return validPali;
    }
}
