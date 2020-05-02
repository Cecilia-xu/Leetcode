// Solution: HashMap
// Time complexity: O(n)
// Space complexity: O(n)
// Note: In this question, the only key just has only one value and the only value also has just one key!
// However, in other circumstances, different keys are likely to share the same value.
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
            return false;
        }
        
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char code = pattern.charAt(i);
            if (!map.containsKey(code)) {
                if (map.values().contains(words[i])) {
                    return false;
                }
                map.put(code, words[i]);
            }
            else {
                if (!map.get(code).equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
