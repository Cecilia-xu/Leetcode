# Algorithms
sumNums = sumLeft + nums\[i\] + sumRight<br>
Therefore, what we are looking for is a index i when sumLeft == sumRight that is sumLeft = sumNums -sumLeft - nums\[i\]
# Pseudocode
```
Input: int[] nums
Output: int pivot

//Initialization
int sumNums <- 0
int sumLeft <- 0
//compute sumNums
for (int num : nums): 
  sumNums = sumNums + num
//traverse the array and check the equation we mentioned above
for (int i -> nums.length - 1):
  // check the equation first (because we decide to make the pivot start from 0)
  // sumLeft: 0 -> larger
  // sumRight: larger -> 0
  if(sumLeft == sumNums - nums[i] - sumLeft) then return i
  sumLeft += nums[i]
//Not found
return -1
```
