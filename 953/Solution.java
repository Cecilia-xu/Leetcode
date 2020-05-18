// Solution 1: HashMap
// Time complexity: O(m + n). m = order.length(), n = words.length;
// Space complexity: O(m)
// Note:** this question is very interesting. We use each character as key and its index as value.
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> charToOrder = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            charToOrder.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            if (!compareWords(charToOrder, words[i - 1], words[i])) {
                return false;
            }
        }
        return true;
    }
    
    private boolean compareWords(HashMap<Character, Integer> charToOrder, String pre, String cur) {
        for (int i = 0; i < pre.length(); i++) {
            // cur[i] does not exists -> cur is shorter
            if (i >= cur.length()) {
                return false;
            }
            // cur[i] exists but the order is smaller 
            if (charToOrder.get(pre.charAt(i)) > charToOrder.get(cur.charAt(i))) {
                return false;
            }
            // else if pre[i] is smaller
            else if (charToOrder.get(pre.charAt(i)) < charToOrder.get(cur.charAt(i))) {
                return true;
            }
        }
        // all characters of pre and characters of current(from 0 to pre.length()-1) are the same
        return true;
    }
}

// Solution 2: Optimization: use array instead of map
// Time complexity: O(m + n). m = order.length(), n = words.length;
// Space complexity: O(1).
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderDic = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderDic[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!compareWords(orderDic, words[i - 1], words[i])) {
                return false;
            }
        }
        return true;
    }
    
    private boolean compareWords(int[] dic, String pre, String cur) {
        for (int i = 0; i < pre.length(); i++) {
            // cur[i] does not exists -> cur is shorter
            if (i >= cur.length()) {
                return false;
            }
            // cur[i] exists but the order is smaller 
            if (dic[pre.charAt(i) - 'a'] > dic[cur.charAt(i) - 'a']) {
                return false;
            }
            // else if pre[i] is smaller
            else if (dic[pre.charAt(i) - 'a'] < dic[cur.charAt(i) - 'a']) {
                return true;
            }
        }
        // all characters of pre and characters of current(from 0 to pre.length()-1) are the same
        return true;
    }
}
