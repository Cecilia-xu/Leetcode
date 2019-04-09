# Pseudocode
Note: The point that we care about is to find the max profit through 1 bought and 1 sell. Notice that the prices is time series data, so we cannot just find the maxium value and the minimum value.
```
Input: int[] prices
Output: int maxProfit

int length = prices.length;

// when prices is null, the maxProfit is 0
if (length == 0) {
  return 0;
}

else {
  //define low and high to record the lowest price we already find, initialize it to prices[0] because we start to search from index 0
  int low <- prices[0]
  //define the maxProfit to record the maxProfit we already find, initialize it to 0 because when the price decreases all the time the maxprofit is 0
  int maxProfit <- 0
  
  for i <-1 to length-1{
    // update the lowest price
    if (prices[1] <= low) then low = prices[i]
    // update maxProfit
    else if (prices[i] - low > maxProfit) then maxProfit = prices[i] - low
    }
    
    return maxProfit
}
```
