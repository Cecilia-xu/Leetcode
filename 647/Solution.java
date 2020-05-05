// Solution: String (Palidrome related)
// Time complexity: O(n). n is the length of string s.
// Space complexity: O(1)
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += constructPali(s, i, i);
            count += constructPali(s, i, i + 1);
        }
        return count;
    }
    
    private int constructPali(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }
}
