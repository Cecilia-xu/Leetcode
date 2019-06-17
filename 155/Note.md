# Intuition
- Find the difference between stack and minStack: It can always get the min value of all elements in stack.
- Difficulties: How to find the minimum immediately when pop the minimium or push the minimum.
# Algorithm
- push(x) -- Push element x onto stack
  - If the number is smaller than current min, push current min before pushing this number.(This operation can make sure that we can get the new min immdiately when we pop the min.)
- pop() -- Removes the element on top of the stack
- top() -- Get the top element
- getMin() -- Retrieve the minimum element in the stack
