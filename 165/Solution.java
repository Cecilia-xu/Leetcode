// My solution
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int i = 0;
        while (i < ver1.length && i < ver2.length) {
            int num1 = removeLeadingZero(ver1[i]);
            int num2 = removeLeadingZero(ver2[i]);
            if (num1 < num2) {
                return -1;
            }
            else if (num1 > num2) {
                return 1;
            }
            i++;
        }
        
        while (i < ver1.length) {
            int num1 = removeLeadingZero(ver1[i]);
            if (num1 == 0 && i == ver1.length - 1) {
                return 0;
            }
            else if (num1 == 0){
                i++;
            }
            else {
                return 1;
            }
        }
        
        while (i < ver2.length) {
            int num2 = removeLeadingZero(ver2[i]);
            if (num2 == 0 && i == ver2.length - 1) {
                return 0;
            }
            else if (num2 == 0) {
                i++;
            }
            else {
                return -1;
            }
        }
        
        return 0;
    }
    
    private int removeLeadingZero(String s) {
        if (s.indexOf(0) == '0' && s.length() == 1) {
            return 0;
        }
        else if (s.indexOf(0) == '0') {
            return removeLeadingZero(s.substring(1, s.length()));
        }
        else {
            return Integer.parseInt(s);
        }
    }
}
