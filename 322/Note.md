# Clarify
- The amount of money given cannot be made up by any combination of the coins? return -1
- The number of coin is infinte? Yes
- Any other complexity requirement?
# Intuition
DP:  MIN question (Typically, all the problems that require to maximize or minimize certain quantity or counting problems that say to count the arrangements under certain condition or certain probability problems can be solved by using Dynamic Programming.)
# Analysis (4 steps)
1. State: 
  - last state: let's see the last coin we added in is ak, what we have already added in is (amount - k) (which just use few coins, not the minimum one);
  - sub-question: How many coins can be combined to make up (amount - k) ?
2. Formulation which represents the relationship among the states
  - let's see f(x) = amount - x, x = min{amount - coins\[0], amount - coins\[1], amount - coins\[2]}


