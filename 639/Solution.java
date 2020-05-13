// Solution: DP
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        // * use long instead
        long[] dp = new long[len + 1];
        // * the question is tend to make us compute result % 10000000007
        int M = 1000000007;
        
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '*' ? 9 : 1);
        for (int i = 2; i <= len; i++) {
            // last one digit is a number
            if (s.charAt(i - 1) != '*') {
                // Case 1: decode s.charAt(i - 1) 
                // last one digit is not zero
                if (s.charAt(i - 1) != '0') {
                    dp[i] += dp[i - 1] % M;
                }
                // Case 2: decode s.substring(i - 2) 
                // 2.1 last two digits can form just one number
                if (s.charAt(i - 2) != '*' && s.charAt(i - 2) != '0') {
                    int num = Integer.parseInt(s.substring(i - 2, i));
                    if (num >= 1 && num <= 26) {
                        dp[i] += dp[i - 2] % M;
                    }
                }
                // 2.2 last two digits can form multiple numbers
                else if (s.charAt(i - 2) == '*'){
                    // * can be both 1 and 2
                    if (s.charAt(i - 1) <= '6') {
                        dp[i] += 2 * dp[i - 2] % M;
                    }
                    // * can just be 1
                    else {
                        dp[i] += dp[i - 2] % M;
                    }
                }
            }
            // last one digit is *
            else {
                // Case 1: decode s.charAt(i - 1) -> 1 - 9
                dp[i] += dp[i - 1] * 9 % M;
                // Case 2: decode s.substring(i - 2) 
                // 2.1 11 - 19
                if (s.charAt(i - 2) == '1') {
                    dp[i] += 9 * dp[i - 2] % M;
                }
                // 2.2 21 - 26
                else if (s.charAt(i - 2) == '2') {
                    dp[i] += 6 * dp[i - 2] % M;
                }
                // 2.3 11 - 19 & 21 - 26
                else if (s.charAt(i - 2) == '*'){
                    dp[i] += 15 * dp[i - 2] % M;
                }
            }
        }
        
        return (int)dp[len] % M;
    }
}
