// My solution: Two HashMaps
// Time complexity: O(n1 + n2)
// Space complexity: O(n1 + n2)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        // map all the numbers and their frequency in nums1
        for (int n1 : nums1) {
            map1.put(n1, map1.getOrDefault(n1, 0) + 1);
        }
        // map all the numbers and their frequency in nums2
        for (int n2 : nums2) {
            map2.put(n2, map2.getOrDefault(n2, 0) + 1);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        // find the frequency of common elements in nums1 and nums2 and add them to the result
        for (int k : map1.keySet()) {
            if (map2.containsKey(k)) {
                int count = Math.min(map1.get(k), map2.get(k));
                int i = 0;
                while (i < count) {
                    res.add(k);
                    i++;
                }
            }
        }
        
        // construct the output
        int[] result = new int[res.size()];
        int index = 0;
        for (int r : res) {
            result[index++] = r;
        }
        return result;
    }
}

// Solution2: One HashMap
// Time complexity: O(n1 + n2)
// Space complexity: O(n1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // map all the numbers and their frequency in nums1
        for (int n1 : nums1) {
            map.put(n1, map.getOrDefault(n1, 0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        // If we find an element of nums2 is in the map, add this element into the result and decrease its corresponding frequency
        for (int n2 : nums2) {
            if (map.containsKey(n2) && map.get(n2) > 0) {
                res.add(n2);
                map.put(n2, map.get(n2) - 1);
            }
        }
        
        int[] result = new int[res.size()];
        int index = 0;
        for (int r : res) {
            result[index++] = r;
        }
        return result;
    }
}
