# Intuition
Reverse the array in place -> change the position of different elements in the array -> two pointers
# Algorithm
We can use two pointers at the same time to do the iteration: one starts from the first element and another starts from the last element. Continue swapping the elements until the two pointers meet each other.
# Complexity
- Time complexity: O(n) <br>
Because we only scan the array once.
- Space complexity: O(1) <br>
  Because we only use one extra space to store the temporary value when swapping.
