# Intuition
We found that we should match every closing bracket with the last opening bracket -> Last In First Out -> Stack
# Algorithm: check by rules mentioned
- Check the bracket one by one
  - If it is an opening bracket, push it into the stack
  - If it is an closing bracket:
  1. If no opening bracket exists, return false
  2. If the last opening bracket is not a match, return false
  3. If the last opening bracket is a match, keep checking
- After checking all the brackets:(DO NOT FORGET!)
  1) If all the brackets have their matches (stack not empty), return true
  2) Else, return false
# Complexity 
- Time complexity: O(n) (scan each character once)
- Space complexity: O(n) (create a stack)
