# Pseudocode
## Approach 1: 
Considering short division, if n is a power of number b, we can keep dividing n by b as long as the remainder becomes 0 and the quotient becomes 1. 

1. my solution is to think about the cases when isPower == true

```
Input: int n
Output: boolean isPower

// case 1: quotient == 1
  if ( n == 1 ) then return true;
// case 2: n can be kept dividing by b (stopped when n == 0
  else if ( n % 3 == 0 && n != 0)  then return isPowerOfThree (n / 3)
// Other cases: false
  else then return false
```

2. official solution is to focus on the range of n 

```
if (n <= 0 ) then return false;

// considering when n>0
while ( n % 3 == 0) 
  n = n/3
if (n == 1) then return true
else then return false
```

- Pros: 从range出发比较容易思考全面不遗漏 
- Time Complexity： O(log3 n)
- Space Complexity:  O(1)
