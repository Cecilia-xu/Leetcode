// Solution 1: Graph (adjacency list)
// Time complexity: 2O(E) + O(N). E is the number of edges. N is the number of nodes.
// Space complexity: O(N). trustLists O(N) + trustToFreq O(N) 
class Solution {
    public int findJudge(int N, int[][] trust) {
        // Edge cases: (ASK! Just one person!)
        if (N == 1 && trust.length == 0) {
            return 1;
        }
        // put the people that i turst into trustList.get(i)b -> construct the graph O(E)
        List<List<Integer>> trustLists = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            trustLists.add(new ArrayList<Integer>());
        }
        for (int[] t : trust) {
            trustLists.get(t[0]).add(t[1]);
        }
        
        // find how many people trust i: O(E)
        HashMap<Integer, Integer> trustToFreq = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            List<Integer> list = trustLists.get(i);
            for (int candidate : list) {
                trustToFreq.put(candidate, trustToFreq.getOrDefault(candidate, 0) + 1);
            }
        }
        
        // O(N)
        int judge = -1;
        for (int candidate : trustToFreq.keySet()) {
            // Rule 1: Everybody trusts the judge (remove unqualified person)
            // Rule 2: The judge trusts nobody (remove unqualified person)
            // Rule 3: exactly one person
            if (trustToFreq.get(candidate) == N - 1 && trustLists.get(candidate).size() == 0) {
                if (judge != -1) {
                    return -1;
                }
                judge = candidate;
            }
        }
        return judge;
    }
}
// Solution 2: two arrays
// Time complexity: O(E)
// Space complexity: O(N)
class Solution {
    public int findJudge(int N, int[][] trust) {
        // corner case:
        if (N == 1 && trust.length == 0) {
            return 1;
        }
        // trustors[i]: how many people do i trust
        int[] trustors = new int[N + 1];
        // trustees[i]: how many people trust i
        int[] trustees = new int[N + 1];
        for (int[] t : trust) {
            trustors[t[0]]++;
            trustees[t[1]]++;
        }
        
        int judge = -1;
        for (int i = 1; i <= N; i++) {
            // Rule 1: Everybody trusts the judge (remove unqualified person)
            // Rule 2: The judge trusts nobody (remove unqualified person)
            // Rule 3: exactly one person
            if (trustees[i] == N - 1 && trustors[i] == 0) {
                if (judge != -1) {
                    return -1;
                }
                judge = i;
            }
        }
        return judge;
    }
}
// Solution 3: one array
// Time complexity: O(E)
// Space complexity: O(N)
class Solution {
    public int findJudge(int N, int[][] trust) {
        // // corner case:
        // if (N == 1 && trust.length == 0) {
        //     return 1;
        // }
        int[] trustScore = new int[N + 1];
        for (int[] t : trust) {
            trustScore[t[0]] = -1;
            trustScore[t[1]]++;
        }
        
        int judge = -1;
        for (int i = 1; i <= N; i++) {
            // Rule 1: Everybody trusts the judge (remove unqualified person)
            // Rule 2: The judge trusts nobody (remove unqualified person)
            // Rule 3: exactly one person
            if (trustScore[i] == N - 1) {
                if (judge != -1) {
                    return -1;
                }
                judge = i;
            }
        }
        return judge;
    }
}
