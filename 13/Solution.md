# My solution: hash table
> Time complexity: O(n) <br> Space complexity: O(1)
```Java
class Solution {
    public int romanToInt(String s) {
        HashMap <Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        
        int res = 0;
        
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == 'I' && i + 1 < s.length() && s.charAt(i + 1) =='V') {
                res += 4;
                i ++;
            }
            else if (s.charAt(i) == 'I' && i + 1 < s.length() && s.charAt(i + 1) =='X') {
                res += 9;
                i ++;
            }
            else if (s.charAt(i) == 'X' && i + 1 < s.length() && s.charAt(i + 1) =='L') {
                res += 40;
                i ++;
            }
            else if (s.charAt(i) == 'X' && i + 1 < s.length() && s.charAt(i + 1) =='C') {
                res += 90;
                i ++;
            }
            else if (s.charAt(i) == 'C' && i + 1 < s.length() && s.charAt(i + 1) =='D') {
                res += 400;
                i ++;
            }
            else if (s.charAt(i) == 'C' && i + 1 < s.length() && s.charAt(i + 1) =='M') {
                res += 900;
                i ++;
            }
            else {
                res += romanMap.get(s.charAt(i));
            }
        }
        
        return res;
        
    }
}
```
