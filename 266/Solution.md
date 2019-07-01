# My solution 1: using array
> Time complexity: O(n) <br> Space complexity: O(1)
```Java
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c] ++;
        }
        boolean isFirstOdd = true;
        for (int f : freq) {
            if (f % 2 == 1 && isFirstOdd) {
                isFirstOdd = false;
            }
            else if (f % 2 == 1 && !isFirstOdd){
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
    public boolean canPermutePalindrome(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c] ++;
        }
        int count = 0;
        for (int f : freq) {
            count += f % 2;
        }
        return count <= 1;
    }
}
```
Note: <br>
1. The variable isFirstOdd is awkward. We can use count += f % 2 as a smart way.
2. Also, compared with using a logical operator, return a logic operation directly is better.
