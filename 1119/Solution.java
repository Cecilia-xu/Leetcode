// Solution: Two pointers + String removal
// [0, i): the result that we are building; [i, j): the range that we detected [j, S.length()): the range we did n
// i - slow pointer, the first position after the tail of the result
// j - fast pointer, scan
// Time complexity: O(n). Scan the element once + build the result O(n)
// Space complexity: O(n) hashset O(1) + res char array O(n)
class Solution {
    public String removeVowels(String S) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        int i = 0, j = 0;
        char[] res = S.toCharArray();
        while (j < res.length) {
            if (vowels.contains(res[j])) {
                j++;
            }
            else {
                res[i] = res[j];
                i++;
                j++;
            }
        }
        return new String(res).substring(0, i);
    }
}
