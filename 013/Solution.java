// Solution: Simulation
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        char pre = s.charAt(0);
        int res = map.get(pre);
        // According to the definition, if the left char's corresponding value is smaller, use subtraction not addition.
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            res += map.get(cur);
            if (map.get(pre) < map.get(cur)) {
                res -= 2 * map.get(pre);
            }
            //* Do not forget to move pointers
            pre = cur;
        }
        
        return res;
    }
}
