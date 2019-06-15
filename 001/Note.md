# Intuition
The question is a searching problem. When we have to search something, map is an important data structure to be applied.
# Algorithm: Two-pass hashmap
- Put all the <nums[i],i> into the dictionary
- Find the complement= target - nums[i]. If we find the complement, break the loop.
# Algorithm: One-pass hashmap
- Check whether the complement of nums[i] is in the map or not.
- If not, add new <nums[i],i> into the map.
# Complexity:
- Time complexity: O(n) The first one is less efficient than the second algorithm. However, both of them have O(n) time complexity.
- Space complexity: O(n) Since we use a hashmap to store the key and value.
