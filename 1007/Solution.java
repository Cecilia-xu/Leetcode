// Solution: 
// Notes: There are only 2 possible cases if we can find an answer. 
// (1) all numbers become A[0] in the end: A and B (2) all numbers become B[0] in the end: A and B
// If they want those two cases become possible in the end, one element at the same position in A and B should be A[0]/B[0].
// A and B will only share the same final state if the answer exists -> result should be the smallest one between A and B.
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int len = A.length;
        // All numbers become A[0] in the end
        for (int i = 0, a = 0, b = 0; i < len && (A[i] == A[0] || B[i] == A[0]); i++) {
            // the count of swap happens in array A (swap when a number is not A[0])
            if (A[i] != A[0]) {
                a++;
            }
            // the count of swap happens in array B (swap when a number is not A[0])
            if (B[i] != A[0]) {
                b++;
            }
            // If we can find the anwser(loops until the end), return the smaller one.
            if (i == len - 1) {
                return Math.min(a, b);
            }
        }
        
        // All numbers become B[0] in the end
        for (int i = 0, a = 0, b = 0; i < len && (A[i] == B[0] || B[i] == B[0]); i++) {
            if (A[i] != B[0]) {
                a++;
            }
            if (B[i] != B[0]) {
                b++;
            }
            if (i == len - 1) {
                return Math.min(a, b);
            }
        }
        
        return -1;
    }
}
