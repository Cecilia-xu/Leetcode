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
  1. state: 
      - Last one: climb[n] which means how many way to climb n steps
      - Sub questions: climb[n] = climb[n - 1] + climb[n - 2] , so climb[n - 1] = ? climb[n - 2] = ? are subquestions
  2. formulating a relation among the states:
      - climb[n] = climb[n - 1] + climb[n - 2]
  3. initial case & corner case:
      - initial case: climb[0] = 1, climb[1] = 1
      - corner case: n == 0. (ARRAY OUT OF BOUND: climb[1])
  4. computing sequence:
      - bottom-up: save memory
# Complexity
- Time complexity analysis: we use n - 1 times the formulation for the relation among states. For each formulation, the time complexity is O(1). Overall, the time complexity is O(n - 1) --> O(n)
- Space complexity analysis: we use an extra array: climb\[n\], whose length is n + 1, the space complexity is O(n + 1) --> O(n)
