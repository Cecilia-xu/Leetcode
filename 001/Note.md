# Intuition
The question is a searching problem. When we have to search something, map is an important data structure to be applied.
# Algorithm: Two-pass hashmap
- Put all the <nums[i],i> into the dictionary (*Note*: There is a risk that hashmap doesn't allow duplicate key. Therefore, the hashmap will lose some information fot the whole array. However, it does not affect we got the right answer since we will traverse the array again. But this solution is not good to extend.)
- Find the complement= target - nums[i]. **Remember to check whether the index we find is as same as i !!!**
If we find the complement, break the loop.
# Algorithm: One-pass hashmap
- Check whether the complement of nums[i] is in the map or not.
- If not, add new <nums[i],i> into the map. (add should be the last step because we might find nums[i])
# Complexity:
- Time complexity: O(n) The first one is less efficient than the second algorithm. However, both of them have O(n) time complexity.
- Space complexity: O(n) Since we use a hashmap to store the key and value.
