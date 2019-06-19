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
### Follow up
- What if the inputs contain unicode characters? How would you adapt your solution to such case?
- Answer
>Use a hash table instead of a fixed size counter. Imagine allocating a large size array to fit the entire range of unicode characters, which could go up to more than 1 million. A hash table is a more generic solution and could adapt to any range of characters.
# My solution 2: using an array instead of hashset
> Time complexity: O(n) <br> Space complexity: O(1)
```Java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < sChar.length; i ++) {
            counter[sChar[i] - 'a'] ++;
            counter[tChar[i] - 'a'] --;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
```
Note:<br>
1. Initialize an array: new int\[26\] without writing any brackets in the end.
2. Since this question is only about letters and we assume all the letters are lower case, we can create an array whose size is 26 to store the frequency of each character.
2. The simplest way to assign the frequency to the correct index is : this character - 'a'
### Write in another way
```Java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            counter[s.charAt(i) - 'a'] ++;
            counter[t.charAt(i) - 'a'] --;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
```
> In this way, we use charAt() instead of toCharArray()
# My solution 3: sorting
> Time complexity: O(nlogn) <br> Space complexity: O(1)
```Java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        for (int i = 0; i < s.length(); i ++) {
            if (sChar[i] != tChar[i]) {
                return false;
            }
        }
        return true;
    }
}
```
### Optimized solution
```Java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar,tChar);
    }
}
```
Note:<br>
1. If we want to compare two differnt arrays, we have to make sure these two arrays have the same length at first.
2. When we want to compare two different arrays, the simpliest way is to use: Arrays.equals(array1,array2)
