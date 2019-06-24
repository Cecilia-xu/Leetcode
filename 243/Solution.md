# My solution
> Time complexity: O(n) <br> Space complexity: O(1)
```Java
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int [] position = {-1, -1};
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i ++) {
            if (word1.equals(words[i])) {
                position[0] = i;
            }
            if (word2.equals(words[i])) {
                position[1] = i;
            }
            if (position[0] != -1 && position[1] != -1) {
                minDistance = Math.min(minDistance, Math.abs(position[0] - position[1]));
            }
        }
        return minDistance == Integer.MAX_VALUE? -1: minDistance;
    }
}
```
Note:<br>
1. Avoid typo! i.e. words[i] NOT word[i] 
### Optimized solution 
> Time complexity : O(n) <br> Space complexity: O(1)
```Java
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int [] position = {-1, -1};
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i ++) {
            if (word1.equals(words[i])) {
                position[0] = i;
                if (position[1] != -1) {
                    minDistance = Math.min(minDistance, Math.abs(position[0] - position[1]));
                }
            }
            if (word2.equals(words[i])) {
                position[1] = i;
                if (position[0] != -1) {
                    minDistance = Math.min(minDistance, Math.abs(position[0] - position[1]));
                }
            }

        }
        return minDistance == Integer.MAX_VALUE? -1: minDistance;
    }
}
```
Note:<br>
This is a more efficient solution because we can avoid to update minDistance even though position is not updated!! We can just compare and update minDistance when position[i] is updated.
