// Solution: dp
// Time complexity: O(n)
// Space complexity: O(n)
// Reference: sample question on Note No.2
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] decodingCount = new int[s.length() + 1];
        char[] word = s.toCharArray();
        decodingCount[0] = 1;
        for (int i = 1; i <= word.length; i++) {
            if (word[i - 1] != '0') {            
                decodingCount[i] += decodingCount[i - 1];
            }
            if (i - 2 >= 0 && isValid(word, i - 2)) {
                decodingCount[i] += decodingCount[i - 2];
            }
        }
        return decodingCount[word.length];
    }
    
    private boolean isValid(char[] word, int i) {
        if (word[i] == '0') {
            return false;
        }
        int code = 10 * (word[i] - '0') + (word[i + 1] - '0');
        if (code > 0 && code <= 26) {
            return true;
        }
        else {
            return false;
        }

    }
}
