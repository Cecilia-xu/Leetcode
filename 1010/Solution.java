// Solution: numPairs quotient -> two sum of mods
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length < 2) {
            return 0;
        }
        
        int[] mods = new int[60];
        int count = 0;
        for (int t : time) {
            mods[t % 60]++;
        }
        for (int i = 1; i < 30; i++) {
            count += mods[i] * mods[60 - i];
        }
        count += mods[0] * (mods[0] - 1) / 2;
        count += mods[30] * (mods[30] - 1) / 2;
        return count;
    }
}
