# Solution: Hash Set
> Time complexity: O(n) <br> Space complexity: O(1)
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
Note:
1. If we want to use char in a string, it is not neccessary to use toCharArray. Instead, charAt can also be considered.
2. The logoic in checking: exist or not -> right position or not -> next pairs of char
