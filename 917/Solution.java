class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder(S);
        int start = 0, end = S.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetter(sb.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetter(sb.charAt(end))) {
                end--;
            }
            if (Character.isLetter(S.charAt(start)) && Character.isLetter(sb.charAt(end))) {
                swap(sb, start, end);
                start++;
                end--;
            }
        }
        return sb.toString();
    }
    
    private void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
}
