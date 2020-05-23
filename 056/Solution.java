// Solution: Intervals (sort start pos + compare and get the max end pos)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        
        // sort the intervals based on their start position
        Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] pre = intervals[0];
        merged.add(pre);
        
        // compare the interval with the previous one
        for (int[] interval : intervals) {
            if (interval[0] <= pre[1]) {
                //*** change the reference to the second number in pre array
                pre[1] = Math.max(pre[1], interval[1]);
            }
            else {
                //*** add the origin interval first
                merged.add(interval);
                pre = interval;
            }
        }
        
        int[][] res = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            res[i] = merged.get(i);
        }
        
        return res;
    }
}

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
