# Clarify
- n range? --> decide the algorithm
- time complexity requirement?
- when n = 0, ?
- when n < 0, ?
# Intuition
- First impression: recursive way (large questions --> small questions which has the same method)
  - Base case: if (n == 0)  climbStairs(n) = 1; / if (n == 1), climbStairs(n) = 1;
  - Recursion rule: climbStairs(n) = climbStairs(n - 1) + climbStairs(n - 2);
  - Time complexity analysis: draw a recursion tree, we use recursion function 2^0 + 2^1 + .... For each step, the time complexity is O(1) --> Time complexity = O(2^n) **VERY COMPLEX*
  - Space complexity analysis: The depth of the recursion tree is n --> The alogrithm use n call stacks. --> Space complexity: O(n)
# Optimation
- Why does the algorithm very complex? it compute too many repeat values.
- How to optimaze? Dynamic programming(4 steps)
  1. final condition: 
      - climb[n] which means
