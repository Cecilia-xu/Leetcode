// Solution 1: BFS
// Time complexity: O(V + E)
// Space complexity: visited array O(n) + queue O(n) -> O(n)
class Solution {
    public boolean isBipartite(int[][] graph) {
        // initialization to store visited state
        // not visited - -1 black - 0 white - 1
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        
        
        // check each node
        for (int i = 0; i < graph.length; i++) { //This graph might be a disconnected graph. So check each unvisited node.
            if (visited[i] != -1) {
                continue;
            }
            
            // bfs: assume i is colored with 0
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visited[i] = 0;
            
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : graph[node]) {
                    // not visited, assign opposite color
                    if (visited[neighbor] == -1) {
                        queue.offer(neighbor);
                        visited[neighbor] = 1 - visited[node];
                    }
                    // color collision
                    else if (visited[neighbor] != 1 - visited[node]) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}


// Solution 2: DFS
// Time complexity: O(V + E)
// Space complexity: O(n). The depth of recursion:O(n) + Visited array O(n) -> O(n)
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == -1 && !fillColor(graph, visited, i, 1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean fillColor(int[][] graph, int[] visited, int node, int color) {
        if (visited[node] != -1) {
            return visited[node] == color;
        }
        visited[node] = color;
        for (int neighbor : graph[node]) {
            if (!fillColor(graph, visited, neighbor, 1 - color)) {
                return false;
            }
        }
        return true;
    }
}
