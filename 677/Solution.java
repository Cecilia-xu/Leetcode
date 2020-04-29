// Solution: Trie
// Detailed explanation about trie: The letter can be treated as a key to find a specific node! 
// The node itself does not contain any info about the letter! -> Searching: we check whether a node is null or not!
class TrieNode {
    public boolean isWord;
    public int val;
    public TrieNode[] children;
    
    public TrieNode() {
        this.isWord = false;
        this.val = 0;
        this.children = new TrieNode[26];
    }
}

class Trie {
    public TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
}

class MapSum {
    public Trie trie;
    public TrieNode root;
    
    /** Initialize your data structure here. */
    public MapSum() {
        this.trie = new Trie();
        this.root = trie.root;
    }
    
    public void insert(String key, int val) {
        TrieNode cur = root;
        for (char c : key.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(); // 这里new的是一个节点，不是一个trie
            }
            cur = cur.children[c - 'a'];  // 指针移动，别忘
        }
        cur.isWord = true;
        cur.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return 0;
            }
            cur = cur.children[c - 'a'];
        }
        
        return sumVal(cur);
    }
    
    private int sumVal(TrieNode cur) {
        int res = (cur.isWord ? cur.val : 0);
        for (TrieNode node : cur.children) {
            if (node != null) {   // 注意条件；节点不为空就沿着节点继续搜索，无需非要到结尾
                res += sumVal(node);
            }
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
