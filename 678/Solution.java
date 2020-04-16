// Solution 1: counting
// Note: This solution is very smart! Since we just need to know whether the string parenthesis is valid or not, we can count
// the cases of the max number of open parenthesises('(' + '*') and the min number of open parenthesises(')'). And minus 1 on
// count when we meet the counterpart characters.
// Our goal: make the number of matches need to be found in the range of [minOpenCount, maxOpenCount]
// Therefore, if maxOpenCount < 0, return false. If minOpenCount < 0, make it become 0.
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public boolean checkValidString(String s) {
        int maxOpenCount = 0, minOpenCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpenCount++;
                maxOpenCount++;
            }
            else if (c == '*') {
                minOpenCount--;
                maxOpenCount++;
            }
            else {
                minOpenCount--;
                maxOpenCount--;
            }
            
            if (maxOpenCount < 0) {
                return false;
            }
            minOpenCount = Math.max(minOpenCount, 0);
        }    
        return minOpenCount == 0;
    }
}
