# Pseudocode
## Solution 1 (Brute Force)
- Tips: Use another array to store the non-zero elements.<br>
1.Traverse and find all the non-zero numbers in an array(store all the non-zero numbers in another arraylist)
2.Put all the non-zero numbers from the arraylist to the array back 
3.Add zero in the end
```
Input: int[] nums
Output: void

//create an array list to store all the non-zero numbers
ArrayList<Integer> nonZeroNums 

//search all the non-zero numbers and store them in the arrayList
for int i -> 0 to nums.length-1:
if ( nums[i] != 0 ) then nonZeroNums.add(nums[i])

// transfer the original array to an array in a required order
int j = 0
for j -> 0 to nonZeroNums.size-1:
nums[i] = nonZeroNums.get(i)
for j - > nonZeroNums.size-1 to nums.length-1
nums[j] = 0
```
- Time Complexity: O(n) (two loops, no nested loop)
- Space Complexity: O()

## Solution 2 (Two pointers)
-Tips: Use one pointer to record the index of non-zero numbers and use another one pointer to traverse the array<br>
1. tranverse and make non-zero number in the right place
2. add zero in the end
```
Input: int[] nums
Output: void

//define a variable to record the index of non-zero numbers
int i = 0

//traverse the array and record all the non zero numbers in the first part
for int j ->0 to nums.length-1:
if (nums[j] != 0) then nums[i] = nums[j] and i++ 

//assign all the elements in the last part to 0
while (i < nums.length):
nums[i] = 0
i++
```

## Solution 3 (Two pointers)
- Tips: Use one pointer to record the index of non-zero numbers and use another one pointer to record the index of zero numbers. Swap the first non-zero numbers and the first zero numbers<br>
1. Tranverse and swap the position of non-zero number and zero
```
Input: int[] nums
Output: void

//define a variable to record the index of non-zero numbers
int i = 0

//traverse the array and record all the non zero numbers in the first part
for int j ->0 to nums.length-1:
if (nums[j] != 0) then nums[i] = nums[j] and i++ 


```
