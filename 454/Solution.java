// Solution: HashMap (Variation of 2Sum)
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> sumToCount = new HashMap<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sumAB = A[i] + B[j];
                sumToCount.put(sumAB, sumToCount.getOrDefault(sumAB, 0) + 1);
            }
        }
        
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sumCD = C[i] + D[j];
                if (sumToCount.containsKey(-sumCD)) {
                    count += sumToCount.get(-sumCD);
                }
            }
        }
        
        return count;
    }
}
