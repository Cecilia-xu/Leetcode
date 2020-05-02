// How to analyze corner cases in a good strucutre?
// Step 1: character types - (1) space (2) sign (3) number (4) others
// Step 2: expected valid input - (spaces/no spaces) + (no sign/one sign) + (numbers) + others (whatever we do not care)
// Step 3: design the logic for checking
// (1) remove leading and trailing spaces -> narrow down our checking for a structure: (no sign/one sign) + (numbers)
// (2) if then we find a character that is neither sign nor digit -> return 0 (as invalid input)
// (3) sign checking: we should and only should find no more than 1 sign -> find 2 signs: return 0 (as invalid input)
// (4) number checking: construct numbers until no digits can be found
//  (4.1) No digit can be found: return 0 (default value - as invalid input)
//  (4.2) Find digits but the number may overflow: return Integer.MIN_VALUE/MAX_VALUE if the number starts overflow
//  (4.3) Find valid digits: break the loop since we do not care characters after numbers
class Solution {
    public int myAtoi(String str) {
        long number = 0;
        char sign = '+';
        boolean foundSign = false;
        // remove leading and trailing spaces
        str = str.trim();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // not a number or a sign
            if (!Character.isDigit(c) && c != '+' && c != '-') {
                return 0;
            }
            // the sign
            else if (c == '-' || c == '+') {
                // multiple signs
                if (foundSign) {
                    return 0;
                }
                sign = c;
                foundSign = true;
            }
            // if a number is found, keep searching all of its digits until no number can be found 
            else if (Character.isDigit(c)) {
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    number = number * 10 + str.charAt(i) - '0';
                    // overflow checking
                    if (number > Integer.MAX_VALUE) {
                        return sign == '+'? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                    i++;
                }
                // no need to keep searching since we have already found the number
                break;
            }
        }
        
        return sign == '+' ? (int)number : (int)-number;
    }
}
