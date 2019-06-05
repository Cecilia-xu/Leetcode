# Solution 1
``` Java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set1 = new TreeSet<Integer>();
        for (int n: nums1) {
            set1.add(n);
        }
        TreeSet<Integer> resultSet = new TreeSet<Integer>();
        for (int n: nums2) {
            if (set1.contains(n)) {
                resultSet.add(n);
            }
        }
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (Integer n: resultSet) {
            result[index ++] = n;
        }
        return result;
    }
}
```
