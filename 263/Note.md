# Intuition
This question is similar to prime number decomposition.
# Algorithm
- Keep dividing these three prime number if n % factor = 0.
- If the remainder is 1, which means no other prime factor exists. It is an ugly number. Otherwise, it is not an ugly number.
# Complexity
- Time complexity:O(log2n+log3n+log5n) Since we can divide 2 log2n times, divide 3 log3n times and divide 5 log5n times.
- Space complexity: O(1)  create an array which contains 2,3,5. O(3)
