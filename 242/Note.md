# Intuition
Check whether string2 has all the alphabet in string2 -> same letters same frequency -> hash table
# Algorithm 1
- Create a hashmap: Key - characters in string1; Value - frequence in string 1
- Check each characters in string 2
  - If the character is not contained in string2, return false
  - If the character is contained in string 2 and the frequency in string1 is 1, remove this key in the map
  - If the character is contained in string 2 and the frequency in string1 is not 1, find the frequency and minus 1 in the map
- Return whether the hash map is empty or not
> We can also use an array whose size is 26 in this questions. But hash table can be generalized.
# Algorithm 2
- Make sure string 1 and string 2 have the same length
- Sort two strings by ASCII of characters
- Compare two arrays
# Complexity
## Algorithm 1
- Time complexity: O(n)
- Space complexity: O(1)  Although we do use extra space, the space complexity is O(1) because the table's size stays constant no matter how large n is.
## Alogrithm 2
- Time complexity: O(nlogn)
- Space complexity: O(1)
## Note
- Space depends on the sorting implementation which, usually, costs O(1) auxiliary space if heapsort is used. Note that in Java, toCharArray() makes a copy of the string so it costs O(n) extra space, but we ignore this for complexity analysis because:
  - It is a language dependent detail.
  - It depends on how the function is designed. For example, the function parameter types can be changed to char[].
