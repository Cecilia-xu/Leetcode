# Intuition
This question is to find duplication. Therefore, we need to check whether an element has been contained in the array or not. -> set
# Algorithm 1: hash set
- Add each element into the set
- Before adding, we should check whether this value containing in the set or not by using contains(). If so, return true. (Which means it has duplication)

# Algorithm 2: sorting array
- As we knoow: if we sort the array. If there is any duplication, nums\[i+1\] == nums\[i\]

# Complexity 1
- Time complexity: O(n)
- Space complexity: O(n)
> Save time by using more space
# Complexity 2
- Time complexity: O(nlogn)
- Space complexity: O(1)
> Save space by using more time
