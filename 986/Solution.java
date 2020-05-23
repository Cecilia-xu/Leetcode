// Solution: Two pointers (谁小移谁)
// Similar question: merger intervals
// Time complexity: O(m + n). m = A.length, n = B.length
// Space complexity: O(m + n).
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        // // sort by starting position
        // Arrays.sort(A, (a1, a2) -> (a1[0] - a2[0]));
        // Arrays.sort(B, (b1, b2) -> (b1[0] - b2[0]));
        
        ArrayList<int[]> res = new ArrayList<>();
        // two pointers
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            if (start <= end) {
                res.add(new int[]{start, end});
            }
            if (end == A[i][1]) {
                i++;
            }
            else {
                j++;
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }
}
