# Note: binary search
## Algorithm & Template
Find variables:
target: x
start: 1
end: x
mid: start + (start - end) / 2
when to return mid: mid <= x / mid && mid + 1 > x / (mid + 1) 
when to change start: mid < x / mid
when to change end: mid > x / mid
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
