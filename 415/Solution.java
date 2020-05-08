// Solution
// Time complexity: O(n + m): Traverse all characters in num1 O(n) + Traverse all characters in num2 O(m)
// Space complexity: O(max(n, m))
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int a = (i < 0 ? 0 : num1.charAt(i) - '0');
            int b = (j < 0 ? 0 : num2.charAt(j) - '0');
            int sum = a + b + carry;
            res.append(sum % 10); //***Not use '0' + sum % 10!!!!!!!!!!!!
            carry = sum / 10;
            i--;
            j--;            
        }
        return res.reverse().toString();
    }
}
