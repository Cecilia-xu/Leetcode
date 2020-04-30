// My solution: learnt from 772 (not the best solution)
class Solution {
    public int calculate(String s) {
        int result = 0;
        int number = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // Number
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }
            
            // Bracket
            if (c == '(') {
                int count = 1;
                int j = i + 1;
                while (j < s.length() && count > 0) {
                    char next = s.charAt(j);
                    if (next == '(') {
                        count++;
                    }
                    if (next == ')') {
                        count--;
                    }
                    j++;
                }
                number = calculate(s.substring(i + 1, j));
                i = j - 1;
            }
            
            // operator
            if ((c != ' ' && !Character.isDigit(c)) || i == s.length() - 1) {
                if (operator == '+') {
                    result += number;  
                }
                else if (operator == '-') {
                    result -= number;
                }
                number = 0;
                operator = c;
            }
        }
        
        return result;
    }
}
