# How to identify a binary search problem?
Binary Search is <strong> an algorithm that divides the search space in 2 after every comparison</strong>. Binary Search should be considered every time you need to <strong> search for an index or element in a collection.</strong> If the collection is unordered, we can always sort it first before applying Binary Search.
# 3 parts of binary search
1. Pre-processing - Sort if collection is unsorted.
2. Binary Search - Using a loop or recursion to divide search space in half after each comparison.
3. Post-processing - Determine viable candidates in the remaining space.
# Template 1
``` Java
int binary search (int[] nums, int target) {
  if (nums == null || nums.length == 0) {
    return -1;
  }
  int left = 0;
  int right = nums.length - 1;
  
  while (left <= right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) {
      return mid;
    }
    else if (nums[mid] < target) {
      left = mid + 1;
    }
    else {
      right = mid - 1;
    }
  }
  
  return -1;
}
```
