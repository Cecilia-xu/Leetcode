class Solution {
    public boolean isNumber(String s) {
        // s is null or empty string
        if (s == null || s.length() == 0) {
            return false;
        }
        // remove space
        s = s.trim();
        // s is null or empty string
        if (s == null || s.length() == 0) {
            return false;
        }
        
        // exponent
        if (s.indexOf('e') != -1) {
            int ePos = s.indexOf('e');
            // e cannot be the first char or the last char
            if (ePos == 0 || ePos == s.length() - 1) {
                return false;
            }
            // before e: a valid decimal / integer (with positive/negative sign) -> check decimal first
            // after e: a valid integer (with positive/ negative sign)
            if (s.charAt(ePos + 1) == '+' || s.charAt(ePos + 1) == '-') {
                return isValidDecimal(s.substring(0, ePos)) && isValidInteger(s.substring(ePos + 2, s.length()));
            }
            return isValidDecimal(s.substring(0, ePos)) && isValidInteger(s.substring(ePos + 1, s.length()));
        }
        // Not exponent: decimal/integer -> check decimal first
        return isValidDecimal(s);
    }
                                 
    private boolean isValidDecimal(String s) {
        // remove the positive/ negative sign
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1, s.length());
        }
        // has dot: 
        // before dot: all elements are numbers without positive/negative sign
        // after dot: all elements are numbers without positive/negative sign
        if (s.indexOf('.') != -1) {
            int dotPos = s.indexOf('.');
            if (dotPos == 0) {
                return isValidInteger(s.substring(dotPos + 1, s.length()));
            }
            else if (dotPos == s.length() - 1) {
                return isValidInteger(s.substring(0, dotPos));
            }
            else {
                return isValidInteger(s.substring(0, dotPos)) && isValidInteger(s.substring(dotPos + 1, s.length()));
            }
        }
        
        // no dot: check integer
        // all elements are numbers without positive/negative sign(remove the sign before)
        return isValidInteger(s);
        
    }
                                  
    private boolean isValidInteger(String s) {
        // null or empty string
        if (s == null || s.length() == 0) {
            return false;
        }
        // check if all characters are digits
        for (char c: s.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
