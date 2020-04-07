// Solution 1: HashMap
// Note: Anagrams attrubute: after sorted: anagrams will become the same string
// Time complexity: the length of String[] is n, the longest length of string is m. 
// Sort each string: O(mlogm) + Char array to String: O(m) + add/create O(1) -> O(mlogm)
// Scan each string in the string array -> O(nmlogm)
// Space complexity: O(nm), 
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String sortedStr = new String(letters);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}

// Solution 2: HashMap (much faster!)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String sortedStr = new String(letters);
            if (!map.containsKey(sortedStr)) {
                List<String> anagrams = new ArrayList<>();
                map.put(sortedStr, anagrams);
            }
            map.get(sortedStr).add(str);
        }
        
        List<List<String>> result = new ArrayList<>();
        for(String s: map.keySet()){
            result.add(map.get(s));
        }
        return result;
    }
}
