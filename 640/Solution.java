// My solution:
// Note: can use int[] instead of creating ResultType
class ResultType {
    public int xCount;
    public int numSum;
    public ResultType() {
        this.xCount = 0;
        this.numSum = 0;
    }
}
class Solution {
    public String solveEquation(String equation) {
        int equalSign = equation.indexOf('=');
        String left = equation.substring(0, equalSign);
        String right = equation.substring(equalSign + 1, equation.length());
        ResultType leftRes = simplify(left);
        ResultType rightRes = simplify(right);
        if (leftRes.xCount == rightRes.xCount) {
            if (leftRes.numSum == rightRes.numSum) {
                return "Infinite solutions";
            }
            else {
                return "No solution";   
            }
        }
        else {
            int xCount = leftRes.xCount - rightRes.xCount;
            int numSum = rightRes.numSum - leftRes.numSum;
            return "x="+numSum / xCount;
        }
    }
    
    private ResultType simplify(String formula) {
        ResultType res = new ResultType();
        char sign = '+';
        for (int i = 0; i < formula.length(); i++) {
            int num = 0;
            // distinguish 'x' with '/ '0x'
            boolean findParameter = false;
            // get the number
            while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                findParameter = true;
                num = num * 10 + (formula.charAt(i) - '0');
                i++;
            }
            // decide the number is the parameter of x
            if (i < formula.length() && formula.charAt(i) == 'x') {
                // 'x' 
                if (!findParameter) {
                    num = 1;
                }
                if (sign == '+') {
                    res.xCount += num;
                }
                else {
                    res.xCount -= num;
                }
                // update i to find the sign
                i++;
            } 
            // or a num
            else {
                if (sign == '+') {
                    res.numSum += num;
                }
                else {
                    res.numSum -= num;
                }
            }
            
            // sign
            if (i < formula.length()) {
                sign = formula.charAt(i);
            }
        }
        return res;
    }
    
    
}
