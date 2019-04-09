# My Solution
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
# Official Solution
```Java
public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
```
Pros: Initialize minprice to Integer.MAX_VALUE and update minprice in the first step of loop
MAX_VALUE: public static final int MAX_VALUE(A constant holding the maximum value an int can have, 2^31-1.)<br>
MIN_VALUE: public static final int MIN_VALUE(A constant holding the minimum value an int can have, 2^31-1.)<br>


Cons: Ignore the situation when prices is null
