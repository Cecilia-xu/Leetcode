// Solution 1: recursion + divide and conquer
// Similar to: calculator (with brackets)
// Time complexity: O(n^2)
class Solution {
    public String decodeString(String s) {
        int num = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num *= 10;
                num += c - '0';
            }
            else if (Character.isLetter(c)) {
                ans.append(c);
            }
            else if (c == '[') {
                // find next corresponding ']'
                int end = i + 1;
                int offset = 1;
                while (end < s.length() && offset > 0) {
                    if (s.charAt(end) == '[') {
                        offset++;
                    }
                    else if (s.charAt(end) == ']') {
                        offset--;
                    }
                    end++;
                }
                
                // recurse and find the sub-problem answer
                String part = decodeString(s.substring(i + 1, end - 1));
                
                // merge the answer
                while (num > 0) {
                    ans.append(part);
                    num--;
                }
                
                // change i
                i = end - 1;
                num = 0;
            }
            else if (c == ']') {
                return ans.toString();
            }
        }
        return ans.toString();
    }
}
