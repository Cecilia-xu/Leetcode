// Time complexity: reverse words in O(n) + reverse the whole string in O(n) + remove space in O(n) = O(n)
// Space complexity: O(n) 
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] characters = s.toCharArray();
        int start = 0;
        while (start < characters.length) {
            int end = start;
            while (end < characters.length && characters[end] != ' ') {
                end++;
            }
            reverse(characters, start, end - 1);
            while (end < characters.length && characters[end] == ' ') {
                end++;
            }
            start = end;
        }
        reverse(characters, 0, characters.length - 1);
        int right = removeSpaces(characters);
        return new String(characters).substring(0, right);
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
    
    private int removeSpaces(char[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!(arr[i] == ' ' && arr[i - 1] == ' ')) {
                arr[j] = arr[i];
                j++;
            }
        }
        return j;
    }
}
