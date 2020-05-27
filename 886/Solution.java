// Solution 1: BFS + initialize the graph using hashmap
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] visited = new int[N];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        initializeGraph(dislikes, map, N);
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0 && !bfs(visited, map, i)) {
                return false;
            }
        }
        return true;
    }
    
    private void initializeGraph(int[][] dislikes, Map<Integer, Set<Integer>> map, int N) {
        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<Integer>());
        }
        for (int[] dislike : dislikes) {
            int first = dislike[0];
            int second = dislike[1];
            map.get(first).add(second);
            map.get(second).add(first);
        }
    }
    
    private boolean bfs(int[] visited, Map<Integer, Set<Integer>> map, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start + 1);
        visited[start] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            Set<Integer> nexts = map.get(cur);
            for (int next : nexts) {
                if (visited[next - 1] == 0) {
                    visited[next - 1] = -visited[cur - 1];
                    queue.add(next);
                }
                else if (visited[next - 1] != -visited[cur - 1]) {
                    return false;
                }
            }
        }
        return true;
   }
}

// Solution 2: BFS + initialzie the graph as lists array
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] visited = new int[N + 1];
        List[] graph = new List[N + 1];
        initializeGraph(dislikes, graph);
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0 && !bfs(visited, graph, i)) {
                return false;
            }
        }
        return true;
    }
    
    private void initializeGraph(int[][] dislikes, List[] graph) {
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] dislike : dislikes) {
            int first = dislike[0];
            int second = dislike[1];
            graph[first].add(second);
            graph[second].add(first);
        }
    }
    
    private boolean bfs(int[] visited, List[] graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List nexts = graph[cur];
            for (int i = 0; i < nexts.size(); i++) {
                int next = (int)nexts.get(i);
                if (visited[next] == 0) {
                    visited[next] = -visited[cur];
                    queue.add(next);
                }
                else if (visited[next] != -visited[cur]) {
                    return false;
                }
            }
        }
        return true;
   }
}

// Solution 3: DFS + initialize the graph as lists array
// Note: the signature of the method is different, you should add the info about the color
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] visited = new int[N + 1];
        List[] graph = new List[N + 1];
        initializeGraph(dislikes, graph);
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0 && !dfs(visited, graph, i, 1)) {
                return false;
            }
        }
        return true;
    }
    
    private void initializeGraph(int[][] dislikes, List[] graph) {
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] dislike : dislikes) {
            int first = dislike[0];
            int second = dislike[1];
            graph[first].add(second);
            graph[second].add(first);
        }
    }
    
    private boolean dfs(int[] visited, List[] graph, int start, int color) {
        visited[start] = color;
        List nexts = graph[start];
        for (int i = 0; i < nexts.size(); i++) {
            int next = (int)nexts.get(i);
            if (visited[next] == 0 && !dfs(visited, graph, next, -color)) {
                return false;
            }
            else if (visited[next] == color) {
                return false;
            }
        }
        return true;
   }
}
