// Solution: dp
// Time complexity: O(n)
// Space complexity: O(n)
// Definition: f[i] is the number of valid decoding ways when length = i
// Equation: f[i] = f[i-1] | S[i-1] is valid + f[i-2] | The number consisting of S[i - 1] and S[i - 2] is valid
// Reference: sample question on Note No.2
class Solution {
    public int numDecodings(String s) {
        // If the string is empty or null
        if (s == null || s.length() == 0) {
            return 0;
        }
        // create an array indexed from 0 to s.length() -> length = s.length() + 1
        int[] decodingCount = new int[s.length() + 1];
        char[] word = s.toCharArray();
        // *decodingCount[0] is different from the cases when s.length() == 0 
        // because it is only used in the dp function when the last 1 or 2 digits is valid
        decodingCount[0] = 1;
        for (int i = 1; i <= word.length; i++) {
            // Check if the last number is valid (not zero)
            if (word[i - 1] != '0') {            
                decodingCount[i] += decodingCount[i - 1];
            }
            // Check if the last two number exists and is also valid
            if (i - 2 >= 0 && isValid(word, i - 2)) {
                decodingCount[i] += decodingCount[i - 2];
            }
        }
        return decodingCount[word.length];
    }
    
    private boolean isValid(char[] word, int i) {
        // The valid code should not have any leading zero
        if (word[i] == '0') {
            return false;
        }
        // Get the code and check its range
        int code = 10 * (word[i] - '0') + (word[i + 1] - '0');
        if (code > 0 && code <= 26) {
            return true;
        }
        else {
            return false;
        }

    }
}
