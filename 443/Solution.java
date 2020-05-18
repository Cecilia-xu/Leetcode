// Solution: String
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int compress(char[] chars) {
        // Optional
        if (chars == null || chars.length == 0) {
            return 0;
        }
        
        // i is the next position for the filling the final answer
        int i = 0;
        char pre = ' ';
        int countPre = 0;
        
        // *******dealing with comparsion between neighbor elements: 
        // loop one more time for checking the last element!!!
        for (int j = 0; j <= chars.length; j++) {
            // get the current character (deal with index out of bound)
            char c = (j < chars.length ? chars[j] : ' '); 
            // find the previous character when j is 0
            if (j == 0){
                pre = c;
            }
            
            // current != pre
            if (c != pre) {
                // record the letter
                chars[i++] = pre;
 
                // if frequency > 1, record the frequency
                if (countPre > 1) {
                    String num = String.valueOf(countPre);
                    for (int k = 0; k < num.length(); k++) {
                        // record the frequency
                        chars[i++] = num.charAt(k);
                    }
                }
                
                // change pre
                pre = c;
                // initialize countPre
                countPre = 1;
            }
            else {
                countPre++;
            }

        }
        return i;
    }
}
