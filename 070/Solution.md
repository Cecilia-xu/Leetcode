# Solution 1: DP
```Java
class Solution {
    public int climbStairs(int n) {
        // Talk the base case of the whole question, because in DP part,
        // we create an array whose length is n + 1, if n == 0, we might got
        // array out of bound error : climb[1] 
        if (n == 0) {
            return 1;
        }
        int[] climb = new int[n + 1];
        // DP base case
        climb[0] = 1;
        climb[1] = 1;
        for (int i = 2; i <= n; i ++) {
            
            climb[i] = climb[i - 1] + climb[i - 2];
        }
        return climb[n];
    }
}
```
