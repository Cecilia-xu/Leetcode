// Solution: based on rows
// Time complexity: O(n). n = s.length()
// Space complexity: O(n)
class Solution {
    public String convert(String s, int numRows) {
        //corner cases
        if (s == null || s.length() <= numRows) {
            return s;
        }
        if (numRows ==  1) {
            return s;
        }
        
        //initialization
        List<StringBuilder> charByRows = new ArrayList<StringBuilder>(numRows);
        for (int i = 0; i < numRows; i++) {
            charByRows.add(new StringBuilder());
        }
        
        // build result list by rows
        int pattern = numRows * 2 - 2;
        for (int i = 0; i < s.length(); i++) {
            int index = i % pattern;
            if (index < numRows) {
                charByRows.get(index).append(s.charAt(i));
            }
            else {
                int move = index - numRows + 1;
                charByRows.get(numRows - 1 - move).append(s.charAt(i));
            }
        }
        
        // format the output
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (charByRows.get(i).length() != 0) {
                res.append(charByRows.get(i));
            }
        }
        return res.toString();
    }
}
