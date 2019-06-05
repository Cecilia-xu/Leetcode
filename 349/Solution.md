# Solution 1
This solution can be an example of TreeSet operation.
``` Java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //Create a new TreeSet
        TreeSet<Integer> set1 = new TreeSet<Integer>();
        for (int n: nums1) {
            // Add an element
            set1.add(n);
        }
        TreeSet<Integer> resultSet = new TreeSet<Integer>();
        for (int n: nums2) {
            // Find an element
            if (set1.contains(n)) {
                resultSet.add(n);
            }
        }
        //Get the size of TreeSet
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (Integer n: resultSet) {
            result[index ++] = n;
        }
        return result;
    }
}
```
