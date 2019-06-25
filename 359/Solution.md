# My solution 1: using hashmap
```Java
class Logger {
    
    private HashMap<String,Integer> map = new HashMap<>();
    /** Initialize your data structure here. */
    public Logger() {
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message,timestamp);
            return true;
        }
        else {
            if (map.get(message) + 10 <= timestamp) {
                map.put(message, timestamp);
                return true;
            }
            else {
                return false;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
```
Note: <br>
1. Be calm! Make sure what you are writing is right before running your code.
2. Map- containsKey/contiansValue!!! set- contains
### Optimized solution
# Optimized solution 2: optimize space
```Java
public class Logger {
    HashSet<String> dic = new HashSet<>();
    Queue<Tuple> q = new LinkedList<>();
  
    public Logger() {}
    
    private static class Tuple {
        int t;
        String msg;
        public Tuple(int t, String msg) {
            this.t = t;
            this.msg = msg;
        }
    } 
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!q.isEmpty() && q.peek().t <= timestamp - 10) {
            String next = q.remove().msg;
            dic.remove(next);
        }
        
        if (!dic.contains(message)) {
            dic.add(message);
            q.add(new Tuple(timestamp,message));
            return true;
        }
        return false;
    }

}
```
