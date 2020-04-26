// Solution: String
// Time complexity: O(n)
// Space complexity: O(n)
// Note: Need to notice that the line which just contains one word is similar to the last line case! If use the method in 
// case 2, computing evenSpaces will be wrong casue the divisor is 0
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int curLen = 0, wordCount = 0, curStart = 0;
        boolean isLastLine = false;
        for (int i = 0; i < words.length; i++) {
            // check the words for a line
            while (i < words.length && curLen + words[i].length() <= maxWidth) {
                if (curLen == 0) {
                    curStart = i;
                }
                curLen += words[i].length();
                wordCount++;
                i++;
            }
            // check whether the space for spaces is guaranteed
            while (curLen + wordCount - 1 > maxWidth) {
                curLen -= words[i - 1].length();
                wordCount--;
                i--;
            }
            // check whether it is the last line 
            if (i == words.length) {
                isLastLine = true;
            }
            // compute the number of spaces
            int spaceCount = maxWidth - curLen;
            // construct the string for each line and add it to the result
            String line = constructLine(words, curStart, i, wordCount, spaceCount, isLastLine);
            result.add(line);
            // recover variables for checking the next line
            i--;
            curLen = 0;
            wordCount = 0;
        }
        
        return result;
    }
    
    private String constructLine(String[] words, int start, int end, int wordCount, int spaceCount, boolean isLastLine) {
        StringBuilder sb = new StringBuilder();
        // Case 1: last line or just one word for a line
        if (isLastLine || wordCount == 1) {
            for (int i = start; i < end; i++) {
                // append word
                sb.append(words[i]);
                // append spaces between different words
                if (spaceCount > 0) {
                    sb.append(" ");
                    spaceCount--;
                }
            }
            // append trailing spaces
            while (spaceCount > 0) {
                sb.append(" ");
                spaceCount--;
            }
            return sb.toString();
        }
        // Case 2: not last line && more than one word
        // assign spaces
        int evenSpaces = spaceCount / (wordCount - 1);
        int moreSpaces = spaceCount % (wordCount - 1);
        for (int i = start; i < end; i++) {
            // append word
            sb.append(words[i]);
            // append spaces between different words
            if (i != end - 1) {
                for (int j = 0; j < evenSpaces; j++) {
                    sb.append(" ");
                }
            }
            // append extra spaces from leftside
            if (moreSpaces > 0) {
                sb.append(" ");
                moreSpaces--;
            }
        }
        return sb.toString();
    }
    
}
