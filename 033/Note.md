# Solution 1: Use more than once binary search
## Algorithm
Consdering the array mentioned in this question is not a sorted array, but we can still use binary search to find the taeget. How?
1. Find the index of the smallest index by using similar method in binary search.
- We notice that when the number is not the smallest number, it must be smaller than the last number and larger than all the front numbers(even the first number in the array).
- Find the mid index and the value in this array.
- Compare nums\[mid\] with nums\[mid + 1\] and nums\[0\]. If it meets the rule we mentioned firstly, we can skip the searching space \[0,mid\]. If it is smaller than nums\[0\], update end index. If it it is larger than nums\[0\], update start index.
2. Compare the target with the first number. If it is smaller than nums\[0\], then the searching area is \[samllest index, nums.length - 1\]. Otherwise, the searching area is \[0, smallest index - 1\].
3. Use basic binary search in the searching area.
## Complexity
- Time complexity: O(logn)
- Space complexity: O(1)
# Solution 2: Use binary search only once
## Algorithm
Just focus on finding the target number without searching two sorted subarrays.
1. Find the mid and nums\[mid\].
2. If nums\[mid\] == target, return mid
3. If nums\[mid\] > nums\[start\]:(which means the sequence is not changed in \[start, mid\])
- If nums\[start\] == target, return start (!等于的情况一定要单独拎出来，以防在后面的书写中造成麻烦和错误)
- If nums\[mid\] > target && nums\[start\] < target, end = mid - 1 (target in the unrotated part, search in the left part)
- If nums\[mid\] > target && nums\[satrt\] > target, start = mid + 1 (target in the rotated part, search in the right part)
- If nums\[mid\] < target, start = mid + 1 (nums\[start\] must be smaller than target, target will not exists in the right part)  
4. If nums\[mid\] < nums\[start\]: (which means the sequence is changed in \[start, mid\])
- If nums\[end\] == target, return end (!)
- If nums\[mid\] < target && nums\[end\] < target, end = mid - 1 (target in the unrotated part, search in the left part)
- If nums\[mid\] < target && nums\[end\] > target, start = mid + 1 (target in the rotated part, search in the right part)
- If nums\[mid\] > target, end = mid - 1 (nums\[end\] must be larger than target.)
## Complexity
- Time complexity: O(logn)
- Space complexity: O(1)
