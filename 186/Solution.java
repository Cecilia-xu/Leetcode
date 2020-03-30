// 三步翻转法
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        for (int start = 0; start < s.length; start++) {
            int end = start;
            while (end < s.length && s[end] != ' ') {
                end++;
            }
            reverse(s, start, end - 1);
            start = end;
        }
        reverse(s, 0, s.length - 1);
    }
    
    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
