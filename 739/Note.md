# Intuition
If we find the temperature of a day is higher than the temperature of the last day, we start to assign a number to res\[\] from the the last day to the day before one by one if the temperature of this day is also lower. -> Last in first out -> Stack
# Algorithm
- Traverse the array and push index i into the stack one by one:
  - Before pushing this index, check whether T\[i\] is larger than T\[stack.peek()\]. If so, pop the index and assign (i-stack.peek()) to res\[stack.peek()\]
# Complexity
- Time complexity: O(n) -> Scan the array once
- Space complexity: O(n) -> Create an array to store results: O(n) + Create a stack(Worst case): O(n) 
