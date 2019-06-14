# Solution: Hash Set
```Java
class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character,Character> numMap = new HashMap<> ();
        numMap.put('0','0');
        numMap.put('1','1');
        numMap.put('6','9');
        numMap.put('8','8');
        numMap.put('9','6');
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (!numMap.containsKey(num.charAt(left)))  return false;
            if (numMap.get(num.charAt(left)) != num.charAt(right))  return false;
            left ++;
            right --;
        }
        return true;
    }
}
```
