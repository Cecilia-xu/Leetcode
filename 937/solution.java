class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                int s1si = s1.indexOf(" ");
                int s2si = s2.indexOf(" ");
                char letter1 = s1.charAt(s1si + 1);
                char letter2 = s2.charAt(s2si + 1);
                if (letter1 <= '9') {
                    if (letter2 <= '9') {
                        return 0;
                    }
                    else {
                        return 1;
                    }
                }
                
                if (letter2 <= '9') {
                    return -1;
                }
                
                int preCompare = s1.substring(s1si + 1).compareTo(s2.substring(s2si + 1));
                if (preCompare == 0) {
                    return s1.substring(0, s1si + 1).compareTo(s2.substring(0, s2si + 1));
                }
                
                return preCompare;
            }
        };
        
        Arrays.sort(logs, comp);
        return logs;
    }
}
