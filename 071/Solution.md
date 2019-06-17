# My solution: using stack
```Java
class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] dir = path.split("/");
        for (String d : dir) {
            if (d.equals("..")) {
                if (!s.isEmpty()) s.pop();
            }
            else if (!d. equals(".") && !d.isEmpty()) {
                s.push(d);
            }
        }
        
        if (s.isEmpty()) return "/";
        String res =  "";
        while(!s.isEmpty()) {
            res = "/" + s.pop() + res;
        }
        
        return res;
     }
}
```
