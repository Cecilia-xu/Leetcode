# Algorithm
- Find pairs of numbers meets the requirement: (0,0) (1,1) (6,9) (9,6) (8,8) and put them in a dictionary
- Use two pointers which start at the right most and left most position:
  - Make sure the opposite char of the char which left pointer points is the same as the char that right pointer points.
    - Check whether the character can be paired (in {0,1,6,8,9})
    - Check whether the left pointer and the right pointer can be paired
    - Move pointers
  # Pseudocode
  ```Java
  Input: String num
  Output: boolean
  
  //Create the dicitonary
  map.put('0','0')...
  
  // create two pointers
  int l = 0, r = nums.length();
  // duizhuangzhizhen
  while (l <= r) then 
    // make sure the target char exist in the array
    if (!map.containsKey(num.charAt(l))) then return false
    // If exist, check the position
    if (map.get(num.charAt(l))!= num.charAt(r)) then return false
    // If positions are right, check next position
    l++
    r--
  
  return true
  ```
  # Complexity
  - Time complexity: O(n) Finding in hashmap is O(1) each time. The size of num is n.
  - Space complexity: O(1) create a hashmap and the size is 5(5 pairs)
