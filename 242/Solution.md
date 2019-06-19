# My solution 1 : using hashset
> Time complexity: O(n) <br> Space complexity: O(n)
``` Java
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        for (char sc : sChar) {
            if (! map.containsKey(sc)) {
                map.put(sc,1);
            }
            else {
                map.put(sc,map.get(sc) + 1);
            }
        }
        char[] tChar = t.toCharArray();
        for (char tc: tChar) {
            if (!map.containsKey(tc)) {
                return false;
            }
            else if (map.get(tc) == 1){
                map.remove(tc);
            }
            else {
                map.put(tc,map.get(tc) - 1);
            }
        }
        return map.isEmpty();
    }
}
```
Note:<br>
1. How to remove a key in hashmap? remove()
2. How to get the value through key? map.get(keyname)
