# Clarify
- The amount of money given cannot be made up by any combination of the coins? return -1
- When amount is 0? return 0(need to clarify!!! I got mistakes here.)
- The number of coin is infinte? Yes
- Any other complexity requirement?
# Intuition
DP:  MIN question (Typically, all the problems that require to maximize or minimize certain quantity or counting problems that say to count the arrangements under certain condition or certain probability problems can be solved by using Dynamic Programming.)
# Analysis (4 steps)
1. State: 
  - last state: let's see the last coin we added in is k (k can be any elements in coins), what we have already added in is (amount - k) (which just use few coins, not the minimum one);
  - sub-question: How many coins can be combined to make up (amount - k) ?
2. Formulation which represents the relationship among the states:
  - let's see we add k as the last step(k can be each element in coins)
  - f(x) = how many coins do we need to make up (amount - k)?
  - So, f(x) = min{f(amount - coins\[0]) + 1, f(amount - coins\[1]) + 1, f(amount - coins\[2]) + 1, ...}
3. Base case & Corner cases:(we can use an array to simulate f)
  - Base case: f\[0] = 0
  - Corner case: f\[(amount - coins\[i])], what about amount - coins\[i] < 0? return Integer.MAX_VALUE
4. Computing sequence: bottom-up, avoid repetitve computation
# Complexity
1. TIme complexity analysis: O(n). We use the formulation for n times. For each formulation, the time complexity is O(1). --> O(n * 1) = O(n)
2. Space complexity analysis: O(n). we created an extra array, whose length is n + 1. O(n + 1) --> O(n)


