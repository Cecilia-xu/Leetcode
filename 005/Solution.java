// Solution 1: Traversal + find possible palidrome
// Trick: expand a palidrome from its center (2 case: length is even / odd)
// Time complexity: O(n^2)
// Space complexity: O(1)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int maxLen = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandPali(s, i, i);
            int len2 = expandPali(s, i - 1, i);
            int len = Math.max(len1,len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - len / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }
    
    private int expandPali(String s, int center1, int center2) {
        while (center1 >= 0 && center2 < s.length() && s.charAt(center1) == s.charAt(center2)) {
            center1--;
            center2++;
        }
        return center2 - center1 - 1;
    }
}

// Solution2: DP
// Notes: index type dp -> sub problem: if the ending index is i, what is the longest palidrome?
// Equation: f(n) = Math.max(f(n - 1), i - n + 1 | isValidPali[i][n])
// Time complexity: O(n ^2)
// Space complexity: O(n ^2)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        boolean[][] validPali = isValidPali(s.toCharArray());
        int maxLen = 1;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (validPali[j][i]) {
                    int len = i - j + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        start = j;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
        
    }

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
