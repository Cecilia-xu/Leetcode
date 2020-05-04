// Solution1: 2 hashsets + Built-in method(set) - retainAll()
// Time complexity: O(len1 + len2)
// Space complexity: O(len1 + len2)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        // build set1 for all elements in nums1
        for (int n1 : nums1) {
            set1.add(n1);
        }
        // build set2 for all elements in nums2
        for (int n2 : nums2) {
            set2.add(n2);
        }
        // intersection
        set1.retainAll(set2);
        
        // output
        int[] res = new int[set1.size()];
        int index = 0;
        for (int n : set1) {
            res[index++] = n;
        }
        return res;
    }
}

// Solution2: 2 hashsets: one for elements, one for results
// Time complexity: O(len1 + len2)
// Space complexity: O(len1 + len2)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int n1 : nums1) {
            set1.add(n1);
        }
        for (int n2 : nums2) {
            if (set1.contains(n2)) {
                set2.add(n2);
            }
        }
        
        int[] res = new int[set2.size()];
        int index = 0;
        for (int n : set2) {
            res[index++] = n;
        }
        return res;
    }
}
