# Pseudocode
This is an example of greedy algorithm. When concerning about optimize the overall result, we can just focus on optimize each step.
```
Input: prices[]
Output: maxProfit

int length <- prices.length

// when prices array is null, return 0
if (length==0) then return 0

// when prices array is not null
else 
  //Initialize maxProfit to 0
  maxProfit<- 0
  
  //earn the profit whenever the prices of next day is higher than i^{th} day
  for i <- 0 to length-1
    if (prices[i] < prices[i+1]) then maxProfit += prices[i+1] - prices[i]
    
  return maxProfit 
```
