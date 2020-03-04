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

# Solution 2
Build-in method
```Java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);
        
        set1.retainAll(set2);

        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }
}
```
