# My solution 1: using hashmap
> Time complexity: O(1)(each time)<br> Space complexity: O(n) (n: the number of the message/overall)
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
3. 涉及不等式问题一定要考虑清楚要不要加=（不等式容易出问题）
### Optimized solution
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
        if (timestamp < map.getOrDefault(message,0)) {
            return false;
        }
        else{
            map.put(message,timestamp + 10);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
 ```
Note:<br>
1. Using getOrDefault method to avoid using containKey: getOrDefault(Object key, V defaultValue)
Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
# Optimized solution 2: optimize space(follow-up)
> Time complexity: O(1) (each time)<br> Space complexity: O(1) (10 space overall)
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
Note：<br>
1. If we have too many messages, hashmap might be blow up. Therefore, we need to optimize space. Since we just need to understand whether the timestamp of this message is in the last 10 or not, we can just store 10 latest tuples to save space.
2. This is a first in first out data structure, so we can use queue to store all tuples. In order to store each tuple as message + timestamp, we should also create a static class named tuple.
3. Define a class: NOT BRACKeTS!!!
