# Algorithm: XOR
Since the array is [0 ... n] which has one missing number, we notice that the index should have be the same as the element. However, one 
element is missing. Therefore, this number will not exist in this array. The result of XOR is this missing number.
- Example:<br>
![Example](https://github.com/Cecilia-xu/Leetcode/blob/master/268/20190610184530.png)
- Reference: https://leetcode.com/problems/missing-number/solution/
 # Complexity
 - Time complexity: O(n)
 Since the time complexity of bit manipulation is O(1), we did bit manipulation in all the elements of the array. Therefore, the time complexity is linearly increasing as the data size increases. The time complexity is O(n).
 - Space complexity: O(1)
