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
            // loop until length-1 because when loop=length-1, prices[i+1] is out of bound
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
<Strong>Be careful to write the range of loop!</Strong>
# Officail solution
```Java
class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
```
Cons: Ignore the situation when prices is null
