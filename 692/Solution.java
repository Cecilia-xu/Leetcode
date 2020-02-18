class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordToFreq = new HashMap<>();
        for (String word : words) {
            wordToFreq.put(word, wordToFreq.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> maxHeap = new PriorityQueue<>((s1, s2) -> 
                                                            wordToFreq.get(s1).equals(wordToFreq.get(s2)) ? 
                                                            s1.compareTo(s2) : wordToFreq.get(s2) - wordToFreq.get(s1));
        for (String word : wordToFreq.keySet()) {
            maxHeap.add(word);
        }
        
        ArrayList<String> ans = new ArrayList<>();
        while (ans.size() < k) {
            ans.add(maxHeap.poll());
        }
        
        return ans;
    }
}
