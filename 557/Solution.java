class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] letters = s.toCharArray();
        for (int start = 0; start < letters.length; start++) {
            int end = start;
            while (end < letters.length && letters[end] != ' ') {
                end++;
            }
            reverse(letters, start, end - 1);
            start = end;
        }
        return new String(letters);
    }
    
    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
