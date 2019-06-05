# Solution 1
## Data Structure: using TreeSet
## Algorithms
- Use set1 to record the numbers in nums1 without any duplication
- Use resultSet to record the intersection of nums1 and nums2
- Create an array and put all the numbers from resultSet to this array 
## Complexity
- Time complexity: O(nlogn)
> This is because we need to traverse the array(O(n)) and add each element by using TreeSet(O(logn)) in each loop. In the worse case, all the
element are different from each other.Therefore, the time complexity must be O(nlogn) + O(nlogn) + O(nlogn) = O(nlogn)
- Space complexity: O(n)
> The space we create are two sets and one array, which are increasing linearly with the data size.
