# Algorithm
Consdering the array mentioned in this question is not a sorted array, but we can still use binary search to find the taeget. How?
1. Find the index of the smallest index.
  1.1 
2. Compare the target with the first number. If it is smaller than nums\[0\], then the searching area is \[samllest index, nums.length - 1\]. Otherwise, the searching area is \[0, smallest index - 1\].
3. Use binary search in the searching area.
