class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i += 2 * k) {
            if (i + k - 1 < letters.length) {
                reverse(letters, i, i + k - 1);
            }
            else {
                reverse(letters, i, letters.length - 1);
            }
        }
        return new String(letters);
    }
    
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
