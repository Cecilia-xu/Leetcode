``` Java
class Solution {

    public int maxProfit(int[] prices) {
    
        int length = prices.length;
        
        // null prices array, return 0
        if (length==0) {
          return 0;
       }
       
       
       else {
          int low = prices[0];
          int maxProfit = 0;

          for (int i = 1; i < length; i++) {
              //update lowest price
              if (prices[i] <= low) {
                  low = prices[i];
              }
              //update maxProfit
              else if (prices[i]-low > maxprofit) {
                  maxProfit = prices[i] - low;
              }
          }
        
          return maxProfit;
          }
    }
    
    
}
```
