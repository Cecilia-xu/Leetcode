// Solution: DP
// Time complexity:
// Space complexity:
// Mistakes conclusion: * marked comments

class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] letters = s.toCharArray();
        boolean[][] validPali = isValidPali(letters);
        int[] partationCount = new int[letters.length + 1];
        partationCount[0] = 0;
        // Note that i and j have different meanings
        // i means the first i letters, partationCount[i] means the minimum number of partationed palidromes in first i letters
        // j means all the indexes before i - 1, partationCount[j - 1] means the minimum number of partationed palidromes in first j letters (end by index j - 1)
        for (int i = 1; i <= letters.length; i++) {
            partationCount[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                //j-1.. i-1 is valid palidrome 
                if (validPali[j][i - 1]) {
                    // This is a solution for the subproblem -> so that it should be similar to the main problem (min not max!)
                    partationCount[i] = Math.min(partationCount[j] + 1, partationCount[i]);
                }
            }
        }
        // find times for partation, need to minus 1
        return partationCount[letters.length] - 1;
    }
    
   // Check all possible palidrome from start to the end. If it is a valid palidrome, make validPali[start][end] = true
   // Time complexity for this method: O(n) initialization + O(n^2) finding all possible palidrome -> O(n^2)
   // Space complexity: O(n^2) for the validPali array
    public boolean[][] isValidPali(char[] s) {
        boolean[][] validPali = new boolean[s.length][s.length];
        for (int i = 0; i < validPali.length; i++) {
            Arrays.fill(validPali[i], false); //* Arrays.fill can only be used into 1-D array
        }
        for (int i = 0; i < s.length; i++) {
            // case 1: the palindrome length is odd, s[i] is the middle element
            int start = i, end = i;
            while (start >= 0 && end < s.length && s[start] == s[end]) {  //* palindrome condition
                validPali[start][end] = true;
                start--;
                end++;
            }
            // case 2: the palindrome length is even, s[i] and s[i - 1] is middle elements
            start = i - 1;  //* start,end are used repetitively, do not declare variables again!
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
