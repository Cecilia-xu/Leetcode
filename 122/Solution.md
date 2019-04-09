# My Solution
``` Java
class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0){
            return 0;
        }
        else {
            int maxProfit = 0;
            for (int i = 0; i < length-1; i++){
                if (prices[i] < prices[i+1]) {
                    maxProfit += prices[i+1] - prices[i];
                }
            }
            return maxProfit;
        }
    }   
}
```
