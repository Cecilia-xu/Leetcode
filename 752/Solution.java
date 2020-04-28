// Solution: BFS
// Time complexity:(1) We will visit all permutations of 4 digits which have 10 numbers for each digit. Therefore, 
// the number of nodes we visit = the number of permutation = 10^4. (2) For each node, we find its next states in O(4) and
// copy them as a string in O(4) and then put it into the arraylist in O(1) = O(4^2). (3) For adding and searchng in hashset:
// O(deadends.length) -> Overall: O(10^4 * 4^2 + deadends.length)
// Space complexity: O(10^4 + deadlock.length): O(10^4) for the queue and visited hashset. O(deadlock.length) for the deadDict.
class Solution {
    public int openLock(String[] deadends, String target) {
        // create a set
        HashSet<String> deadDic = new HashSet<>();
        for (String deadend : deadends) {
            deadDic.add(deadend);
        }
        // dead initial lock or terminal lock
        if (deadDic.contains("0000") || deadDic.contains(target)) {
            return -1;
        }
        // initial lock is also in the terminal state
        if (target.equals("0000")) {
            return 0;
        }
        // BFS
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            // visit all nodes in the same step
            for (int i = 0; i < size; i++) {
                String lock = queue.poll();
                ArrayList<String> newLocks = findNext(lock);
                for (String nl : newLocks) {
                    if (!deadDic.contains(nl) && !visited.contains(nl)) {
                        queue.offer(nl);
                        visited.add(nl);
                        if (nl.equals(target)) {
                          return step + 1;
                        }
                    }
                } 
            }
            step++;
        }
        return -1;
    }
    
    private ArrayList<String> findNext(String lock) {
        ArrayList<String> nexts = new ArrayList<>();
        char[] codes = lock.toCharArray();
        for (int i = 0; i < codes.length; i++) {
            char code = codes[i];
            // plus one
            codes[i] = Character.forDigit((codes[i] - '0' + 1) % 10, 10);   //*******Character.forDigit(number, radix) Transform to a number character 
            nexts.add(new String(codes));
            codes[i] = code;      //*****Recover before try another state in the same digit!!!(DO NOT FORGET!)
            // minus one
            codes[i] = Character.forDigit((codes[i] - '0' + 9) % 10, 10);
            nexts.add(new String(codes));
            codes[i] = code;
        }
        return nexts;
    }
}
