// Solution: Topologicl sorting(use bfs)
// Time complexity: O(V + E)
// Space complexity: O(V + E)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        
        // create the list to store the order
        List<Integer> order = new ArrayList<>();
        
        // pop the node whose indegree is 0, add it to the result and update indegree
        // keep popping until the queue is empty
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            order.add(vertex);
            for (int i = 0; i < graph[vertex].size(); i++) {
                int next = (int)graph[vertex].get(i);
                indegree[next]--;
                // 注意这里一定要加一个强制类型转换！edges[course].get(i)拿出来会是Object类型的，不能直接放到int容器里。
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
       
       // post-processing: check whether a graph is a directed acyclic graph
       if (order.size() != numCourses) {
           return new int[0];
       }
        else {
            int[] result = new int[order.size()];
            for (int i = 0; i < order.size(); i++) {
                result[i] = order.get(i);
            }
            return result;
        }
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
