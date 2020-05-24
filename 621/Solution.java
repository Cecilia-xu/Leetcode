// Solution: greedy
// Time complexity: O(n)
// Space complexity: O(1)
// Find pattern for this solution: 1. find the character whose frequency is the largest e.g. A(3)B(3) A.....A.....AB
// 2. The number of intervals whose length = n + 1 should be freq[A] - 1 
// 3. However, if there are i characters whose frequency is the same as A's -> freq[A]-th interval's length should be i
// 4. Total length = (0 ... (freq[A] - 1th) total length) + freq[A]th length
// 5. Edge case: we cannot use all characters based on this strategy -> At this time, we do not need any idle and should
// return tasks.length
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (int t : tasks) {
            freq[t - 'A']++;
        }
        Arrays.sort(freq);
        int i = 0;
        while (i < 26 && freq[25 - i] == freq[25]) {
            i++;
        }
        //******Edge case: this strategy cannot cover all tasks
        return Math.max(tasks.length, (freq[25] - 1) * (n + 1) + i);  
    }
}
