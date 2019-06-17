# My solution
> Time complexity:O(n) <br> Space complexity: O(n)
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
Note:<br>
1. The way we represent the path in Unix: 
    - ".." -return to last directory
    - "." - stay in this directory
2. Split the string by a specific symbol: use .split("the symbol"). Important example: "//" in this question will also be split as an empty string  ""!!!
3. In stack, we MUST ALWAYS CHECK IF THE STACK IS EMPTY OR NOT WHEN WE POP SOMETHING!!!!!!
