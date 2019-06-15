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
            if (i + 1 < s. length() && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                res += romanMap.get(s.charAt(i + 1)) - romanMap.get(s.charAt(i));
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
注意：理解题目规则，不是只有仅仅列出的情况，要把它一般化
### Optimized solution
```Java
public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        char[] sChar = s.toCharArray();
        int res = toInt(sChar[0]);
        for (int i = 1; i < s.length; i ++) {   
            res += sChar[i];
            if (toInt(sChar[i]) > toInt(sChar[i - 1])) {
                res -= 2 * toInt(sChar[i - 1]);
            }
        }
        return res;
    }
    
    private int toInt(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
```
Note: <br>
- 运用数组和switch效率更高（原因不详，但是性能就是高）

