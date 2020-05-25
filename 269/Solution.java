// Solution: topological sort
// Time complexity: O(n * m). n words, m = words[i].length
// Space complexity: O(V + E). V = unique letters count, E = edges we find
class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] indegree = new int[26];
        if (!constructGraph(words, graph, indegree)) {
            return "";
        }
        return bfs(graph, indegree);
    }
    
    private boolean constructGraph(String[] words, Map<Character, Set<Character>> graph, int[] indegree) {
        // intialization
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<Character>());
                }
            }
        }
        // construct graph
        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String cur = words[i];
            // *******cur is the prefix of pre -> invalid edge
            // BUT! cur is not pre!
            if (pre.length() > cur.length() && pre.startsWith(cur)) {
                return false;
            }
            int len = pre.length();
            for (int j = 0; j < len; j++) {
                if (pre.charAt(j) != cur.charAt(j)) {
                    char first = pre.charAt(j);
                    char second = cur.charAt(j);
                    // add new edge: first -> second
                    // update indegree
                    if (!graph.get(first).contains(second)) {
                        graph.get(first).add(second);
                        indegree[second - 'a']++;
                    }
                    // *****break!!!!(Since we have already find this edge)
                    break;
                }
            }
        }
        return true;
    }
    
    private String bfs(Map<Character, Set<Character>> graph, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        // add all nodes whose indegrees are 0 into the queue
        for (char c : graph.keySet()) {
            if (indegree[c - 'a'] == 0) {
                queue.add(c);
            }
        }
        // update the answer during the topological sorting
        while (!queue.isEmpty()) {
            char letter = queue.poll();
            sb.append(letter);
            for (char next : graph.get(letter)) {
                indegree[next - 'a']--;
                if (indegree[next - 'a'] == 0) {
                    queue.add(next);
                }
            }
        }
        // check whether the graph is acyclic
        return sb.length() == graph.size() ? sb.toString() : "";
    }
}
