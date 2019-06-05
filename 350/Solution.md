# Solution1
``` Java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        for (int n: nums1) {
            if (map1.containsKey(n)) {
                map1.put(n,map1.get(n) + 1);
            }
            else {
                map1.put(n, 1);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int n: nums2) {
            if (map1.containsKey(n) && map1.get(n) > 0) {
                result.add(n);
                map1.put(n,map1.get(n)-1);
            }
        }
        
        int[] intersection = new int[result.size()];
        int index = 0;
        for (Integer n: result) {
            intersection[index ++] = n;
        }
        
        return intersection;
        
    }
}
```
