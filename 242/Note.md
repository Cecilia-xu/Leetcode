# Intuition
Check whether string2 has all the alphabet in string2 -> same letters same frequency -> hash table
# My algorithm
- Create a hashmap: Key - characters in string1; Value - frequence in string 1
- Check each characters in string 2
  - If the character is not contained in string2, return false
  - If the character is contained in string 2 and the frequency in string1 is 1, remove this key in the map
  - If the character is contained in string 2 and the frequency in string1 is not 1, find the frequency and minus 1 in the map
- Return whether the hash map is empty or not
