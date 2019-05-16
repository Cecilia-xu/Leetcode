# Note: binary search
## Algorithm & Template
Find variables:
1. target: x
2. start: 1
3. end: x
4. mid: start + (start - end) / 2
5. when to return mid: mid <= x / mid && mid + 1 > x / (mid + 1) 
6. when to change start: mid < x / mid
7. when to change end: mid > x / mid
## Pseudocode
Input: int x
Output: int i
```
if (x == 0) then return 0
int start = 1, end = x
while (start <= end):
  int mid = start + (start - end) / 2
  if (mid <= x / mid && mid + 1 > x / (mid + 1) then return mid
  else if (mid < x / mid) then start = mid + 1
  else then end = mid - 1
return start
```
## Complexity
- Time complexity: O(logn)
- Space complexity: O(1)
