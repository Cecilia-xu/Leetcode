# Solution1: Hash Set
> Time complexity: O(J.length + S.length) <br> Space complexity: O(S.length)
```Java
class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> Jset= new HashSet<>();
        for (char j : J.toCharArray()) {
            Jset.add(j);
        }
        
        int res = 0;
        for (char s: S.toCharArray()) {
            if (Jset.contains(s)) res++;
        }
        return res;
    }
}
```
Note: String to Array- stringName.toCharArray()
