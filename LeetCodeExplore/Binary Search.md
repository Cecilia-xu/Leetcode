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
```  
Template #1 is used to search for an element or condition which can be determined by <strong>accessing a single index</strong> in the array.
### Key Attributes
- Search Condition can be determined without comparing to the element's neighbors (or use specific elements around it)
- No post-processing required because at each step, you are checking to see if the element has been found. If you reach the end, then you know the element is not found.
### Distinguishing Syntax
- Initial Condition: left = 0, right = length - 1
- Termination: left > right(!)
- Searching Left: right = mid - 1
- Searching Right: left = mid + 1
### My conclusion
This template can be used into some questions in which you have to find a single index in the array. Also, you can compare any 2 numbers in the array. 
# Template 2
``` Java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length;
  while(left < right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid; }
  }

  // Post-processing:
  // End Condition: left == right
  if(left != nums.length && nums[left] == target) return left;
  return -1;
}
```
### conclusion
Reference:https://github.com/yuzhoujr/leetcode/issues/8
# 做题总结
1. binary search的本质->减半&找到第一个使得g（x）成立的index
2. Template
```Java
int binary search (int[] nums, int target) {
  int low = 0, high = nums.length;
  
  while (low < high) {
    int mid = low + (high - low) / 2;
    //可有可无
    if (nums[mid] == target) {
      return mid;
    }
    //g(x)
    else if (nums[mid] > target) {
      high = mid;
    }
    else {
      low = mid - 1;
    }
  }
  
  return low;
```
3. 左闭右开或者左闭右闭都可以，重要的是后续代码要保证定义的一致。但是经验来看，在需要避免整形溢出的情况下，即最大数可能取到Integer.MAX_VALUE的时候，尽可能选择左闭右闭比较好操作
4. 题目中会经常存在整型溢出的考点（比如：数字翻转 or 乘法 or 加法），这个时候可以考虑把mid，low，high都设成long型，但一定要记得return时候转换；另外还需要注意，当出现整型溢出时应当return什么值，有时候题目会提到。
5. 做除法要小心出现除数为0程序错误的情况
6. 需要注意题目要求返回的到底是什么，不一定是index，有可能是对应的值
