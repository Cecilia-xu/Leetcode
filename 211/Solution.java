// Solution: Trie
class TrieNode {
    public boolean isWord;
    public TrieNode[] childern;
    
    public TrieNode() {
        this.isWord = false;
        this.childern = new TrieNode[26];
    }
}

class Trie {
    public TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
}

class WordDictionary {
    public Trie trie;
    public TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.trie = new Trie();
        this.root = new TrieNode();
    }
    
    // Time : O(word.length())
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }
    
    private boolean searchHelper(String word, TrieNode cur, int start) {
        if (start == word.length()) {
            return cur.isWord;      //***** return cur.isWord not true!
        }
        
        char letter = word.charAt(start);
        // found a '.'
        if (letter == '.') {
            for (TrieNode child : cur.childern) {
                // If we find a match
                if (child != null && searchHelper(word, child, start + 1)) {
                    return true;
                }
            }
            return false;
        }
        // found a letter
        else if (cur.childern[letter - 'a'] != null) {
            cur = cur.childern[letter - 'a'];
            return searchHelper(word, cur, start + 1);
        }
        // cannot found a letter
        else {
            return false;
        }

    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
