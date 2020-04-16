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
// Other explanation: Have two counters one counter (cmax) for counting the maximum number of right braces we can accommodate with current left braces and stars.
//Have a second counter(cmin) which represents the minimum number of right braces that must be there further to make sure the whole string is valid(this number can’t be negative, so if it becomes negative then we put it to zero.
//At any time, if cmax becomes negative, it means we can’t accommodate current right braces with current left braces and stars. So, we return false.
//In the end if cmin is positive then it means that at least there should be a cmin number of right braces to make sure the overall string is valid. So, we check whether cmin is zero or not and return the answer
