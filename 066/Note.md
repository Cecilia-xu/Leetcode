# Algorithm
1. Check from the last digit to the first digit. If it is less than 9, plus one directly.
2. Keep checking until the first digit.
3. Create a new array to enlarge the size of the array.
# Pseudocode
```
Input: int[] digits
Output: int[]

for (int i <- digit.length - 1 to 0)
  if (digits[i] < 9) then digits[i] ++ and return digit
  else digits[i] = 0
  
if (digits[0] == 0) then int[] newDigits = new int[digit.length + 1]
  newDigits[0] = 1

```
