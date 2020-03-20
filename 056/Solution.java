// Time complexity: O(nlogn)
// Space complexity: O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        
        Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0])); // Interval: sort at first!!!
        List<int[]> results = new ArrayList<>();
        int[] lastInterval = intervals[0];
        results.add(lastInterval);
        for (int[] i : intervals) {
            if (i[0] <= lastInterval[1] && i[0] >= lastInterval[0]) {
                lastInterval[1] = Math.max(i[1], lastInterval[1]); // How to change a value in 2 dimensional array which is added in the arraylist
            }
            else {
                lastInterval = i;
                results.add(i);
            }
        }
        
        return results.toArray(new int[results.size()][]); // How to transform a list to an array
    }
}
