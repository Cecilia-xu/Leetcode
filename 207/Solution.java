// Solution 1: Topological sort
// Time complexity: O(V + E)
// Space complexity: O(V + E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] graph = constructGraph(numCourses, prerequisites);
        // check indegree
        int[] indegree = checkIndegree(numCourses, prerequisites);
        // put the nodes whose indegree is 0 into the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        // pop the node whose indegree is 0 and update indegree
        // keep popping until the queue is empty
        int count = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            count++;
            for (int i = 0; i < graph[vertex].size(); i++) {
                int next = (int)graph[vertex].get(i);
                indegree[next]--;
                // 注意这里一定要加一个强制类型转换！edges[course].get(i)拿出来会是Object类型的，不能直接放到int容器里。
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return count == numCourses;
    }
    
    private List[] constructGraph(int numCourses, int[][] edges) {
        List[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for (int[] edge : edges) {
            graph[edge[1]].add(edge[0]);
        }
        
        return graph;
    }
    
    private int[] checkIndegree(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            indegree[edge[0]]++;
        }
        return indegree;
    }
}

// Solution 2: Basic DFS
// Time complexity: O(V + E)
// Space complexity: O(V + E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = constructGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }
    
    private Map<Integer, Set<Integer>> constructGraph(int vertex, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < vertex; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
        }
        
        return graph;
    }
    
    private boolean isCyclic(Map<Integer, Set<Integer>> graph, boolean[] visited, int start) {
        if (visited[start]) {
            return true;
        }
        if (graph.get(start).size() == 0) {
            return false;
        }
        
        visited[start] = true;
        for (int next : graph.get(start)) {
            if (isCyclic(graph, visited, next)) {
                return true;
            }
        }
        // ****backtracking
        visited[start] = false;
        return false;
    }
}

// Solution 3: refined DFS (DFS + memoization)
// Time complexity: O(V + E)
// Space complexity: O(V + E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = constructGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        // memoization
        boolean[] checked = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(graph, visited, i, checked)) {
                return false;
            }
        }
        return true;
    }
    
    private Map<Integer, Set<Integer>> constructGraph(int vertex, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < vertex; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
        }
        
        return graph;
    }
    
    private boolean isCyclic(Map<Integer, Set<Integer>> graph, boolean[] visited, int start, boolean[] checked) {
        // means has already checked as acyclic before
        if (checked[start]) {
            return false;
        }
        // visited a node 
        if (visited[start]) {
            return true;
        }
        // no vertexes that start can points to
        if (graph.get(start).size() == 0) {
            return false;
        }
        
        visited[start] = true;

        for (int next : graph.get(start)) {
            if (isCyclic(graph, visited, next, checked)) {
                return true;
            }
        }
        // ****backtracking & ensure that there is no cycle when starts at "start"
        visited[start] = false;
        checked[start] = true;
        return false;
    }
}
