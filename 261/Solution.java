// Solution 1: BFS (floodfill algorithm)
// Notes: In this solution, we use the definition: A (1)connected graph with (2)n vertexes and n-1 edges is a tree
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Validate the number of vertexes
        if (n == 0) {
            return false;
        }
        
        // Validate the number of edges
        if (edges.length != n - 1) {
            return false;
        }
        
        HashMap<Integer, Set<Integer>> graph = initializeMap(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int vertex1 = queue.poll();
            for (int vertex2 : graph.get(vertex1)) {
                if (!visited.contains(vertex2)) {
                    queue.offer(vertex2);
                    visited.add(vertex2);
                }
            }
        }
        //If we visited all nodes, which means the graph is connected.
        return visited.size() == n;
    }
    
    // Initialze the edges array to an adjacency list
    // Why use hashset? If the edges array have duplicate edges, hashset can deduplicate.
    // In this question, arraylist can replace hashset because the question assumes no duplication in edges.
    public HashMap<Integer, Set<Integer>> initializeMap (int n, int[][] edges) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        // create "list" for different edges
        for (int i = 0; i < n ; i++) {
            map.put(i, new HashSet<Integer>());
        }
        // initialize the adjacency list
        // Note: add two times because: (1) vertex1 to vertex2 (2) vertex2 to vertex1
        // Note: how to write for loop for int[][]
        for (int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];
            map.get(vertex1).add(vertex2);
            map.get(vertex2).add(vertex1);
        }
        return map;
    }
}
// Solution 2: Union Find 
// Notes: In this solution, we use the definition: A (1)acyclic graph with (2)n vertexes and n-1 edges is a tree
// Time complexity: O(nlog*(n)). 
// Why it is better than solution 1? Time complexity ignores constant.(Refer: https://leetcode.com/articles/graph-valid-tree/)
// Space complexity: O(n). O(n) for extra space: father[]
class Solution {
    public int[] father;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        connectingGraph(n);
        for (int[] edge : edges) {
            // If edge[0] and edge[1] is already connected and there is an edge between them, there must exist a cycle.
            if (find(edge[0]) == find(edge[1])) {
                return false;
            }
            // If edge[0] and edge[1] has not connected yet, use union to these nodes.
            union(edge[0], edge[1]);
        }
        return true;
    }
    
    public void connectingGraph(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    
    public int find(int vertex) {
        if (father[vertex] == vertex) {
            return vertex;
        }
        return father[vertex] = find(father[vertex]);
    }
    
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
        }
    }
}
