// Solution: simulation
// Time complexity: O(n1 * n2)
// Space complexity: O(n1 + n2)
// Note: this question can not be sloved by using long type to record the sum of the products. This is because the answer 
// might be overflow long type as well.
class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        // create an array to store the number of result on different digit
        int[] product = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                // get the final result of sum on each digit after adding new product
                int sum = product[i + j + 1] + n1 * n2;
                // get the final number on this result and add carry to the former digit
                product[i + j] +=  sum / 10;
                product[i + j + 1] = sum % 10;
            }
        }
        
        // construct the result
        StringBuilder res = new StringBuilder();
        for (int n : product) {
            // remove leading zeros
            if (res.length() == 0 && n == 0) {
                continue;
            }
            res.append(n);
        }
        
        // consider the case when the final result is 0
        return res.length() == 0 ? "0" : res.toString();
    }
}
