// Solution 1: DFS
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
         HashSet<Integer> visited = new HashSet<>();
         visited.add(0);
         dfs(rooms, visited, 0);
         return visited.size() == rooms.size();
     }
    
    private void dfs(List<List<Integer>> rooms, HashSet<Integer> visited, int cur) {
        List<Integer> keys = rooms.get(cur);
        for (int k : keys) {
            if (!visited.contains(k)) {
                visited.add(k);
                dfs(rooms, visited, k);
            }
        }
    }
}

// Solution 2: BFS
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;
        int visitedRooms = 1;
        
        // bfs
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> keys = rooms.get(node);
            for (int k : keys) {
                if (!visited[k]) {
                    queue.offer(k);
                    visited[k] = true;
                    visitedRooms++;
                }
            }
        }

        return visitedRooms == rooms.size();
     }
}
