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
// Solution 2: Union Find ???
