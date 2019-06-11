# My solution: Bit manipulation
> - Time complexity: O(1) 
- Space complexity: O(1)
```Java
class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i ++) {
            if ( ((x ^ y) & mask) != 0 ) {
                count ++;
            }
            mask <<= 1;
        }
        return count;
    }
}
```
