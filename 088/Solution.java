// Two pointers: from end to start
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            }
            else {
                nums1[k--] = nums2[j--];
            }
        }
        // since i is the index of nums1, the remaining elements in nums1 has no need to be moved.
//         while (i >= 0) {
//             nums1[k--] = nums1[i--];
//         }
        
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
