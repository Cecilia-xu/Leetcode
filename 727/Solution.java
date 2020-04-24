// Solution 1: two pointers
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public String minWindow(String S, String T) {
        int sIndex = 0, tIndex = 0;
        int minLen = Integer.MAX_VALUE, minStart = 0, start = 0;
        while (sIndex < S.length()) {
            if (S.charAt(sIndex) == T.charAt(tIndex)) {
                if (tIndex == 0) {
                    start = sIndex;
                }
                tIndex++;
            }
            if (tIndex == T.length()) {
                int newStart = sIndex;
                // Note the optimization here! Search backwards!
                while (newStart >= start) {
                    if (S.charAt(newStart) == T.charAt(tIndex - 1)) {
                        tIndex--;
                    }
                    if (tIndex == 0) {
                        start = newStart;
                        break;
                    }
                    newStart--;
                }
                int len = sIndex - start + 1;
                if (len < minLen) {
                    minLen = len;
                    minStart = start;
                }
                tIndex = 0;
                sIndex = start + 1;
                continue;
            }
            sIndex++;
        }
        
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        else {
            return S.substring(minStart, minStart + minLen);
        }
    }
}

