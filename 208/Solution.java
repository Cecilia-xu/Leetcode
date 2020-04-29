// Solution: Trie implementation (trienode implementation is based on array -> can be changed to hashmap/treemap)
// Note: A tree-based(N-ary) data structure
// Key Points about trie: 
// 1. During searching: we check whether a node is null or not!
// The letter can be treated as a key to find a specific node! The node itself does not contain any info about the letter!
// If the letter exist, we must create a node with the letter key and so that the node is not null.
// 2. Return statement: different in searching prefix and searching word (true v.s  cur.isWord!!)
class TrieNode {
    public boolean isWord;
    public TrieNode[] childern;
    
    public TrieNode() {
        this.isWord = false;
        this.childern = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    // Time: O(word.length())
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.childern[c - 'a'] == null) {
                cur.childern[c - 'a'] = new TrieNode();
            }
            cur = cur.childern[c - 'a'];
        }
        cur.isWord = true;
    }
    
    // Time: O(word.length())
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.childern[c - 'a'] == null) {
                return false;
            }
            cur = cur.childern[c - 'a'];
        }
        return cur.isWord;
    }
    
    // Time: O(prefix.length)
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.childern[c - 'a'] == null) {
                return false;
            }
            cur = cur.childern[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
