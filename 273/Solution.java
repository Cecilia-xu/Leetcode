class Solution {
    public String[] lessThanTenMaps = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    public String[] lessThanTwentyMaps = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public String[] lessThanHundredMaps = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String[] units = new String[]{"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        List<String> res = new ArrayList<>();
    
        // 0
        if (num == 0) {
            return lessThanTenMaps[num];
        }
        
        int pos = 0, threeDigits = 0;
        while (num != 0) {
            threeDigits = num % 1000;
            num = num / 1000;
            if (pos != 0 && threeDigits != 0) {
                res.add(0, units[pos]);
            }
            getThreeDigitsWord(res, threeDigits);
            pos++;
        }
        
        return buildAns(res);
    }
    
    private void getThreeDigitsWord(List<String> res, int num) {
        int num1 = num % 10;
        int num2 = num / 10 % 10;
        int num3 = num /100 % 10;
        
        // two digits
        // 10, .. ,19
        if (num2 == 1){
            res.add(0, lessThanTwentyMaps[num1]);
        }
        
        // last digits: 1, .. , 9, 20,...,99
        else if (num1 > 0) {
            res.add(0, lessThanTenMaps[num1]);
        }
        if (num2 > 1) {
            res.add(0, lessThanHundredMaps[num2]);
        }
    
        
        // first digit
        if (num3 != 0) {
            res.add(0, "Hundred");
            res.add(0, lessThanTenMaps[num3]);
        }
    }
    
    private String buildAns(List<String> res) {
        StringBuilder sb = new StringBuilder();
        int size = res.size();
        for (int i = 0; i < size - 1; i++) {
            sb.append(res.get(i));
            sb.append(" ");
        }
        return sb.append(res.get(size - 1)).toString();
    }
}
