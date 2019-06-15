# Intuition
- Simulate the process in this question.
-Find the rule of the transfer:
  - If the letter which represents a smaller number is placed before another letter which represents a larger number. Add difference between these two numbers.
  - Otherwise, add each number.
# Algorithm
- Use hashmap as a dictionary to map the letter and the number.
- Scan the string and check the rules mentioned above.
# Complexity
- Time complexity: O(n) Since we just scan the string once and the operation in hash table is just O(1).
- Space complexity: O(1) Since we create a map which just has constant number of pairs.
