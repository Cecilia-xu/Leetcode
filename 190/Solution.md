# My Solution
```
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int output = 0;
        for (int i = 0; i < 32; i++) {
            output <<= 1;
            output += (n & 1);
            n >>= 1;
        }
        return output;
    }
}
```
