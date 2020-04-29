// My solution: DFS + Trie
class TrieNode {
    public boolean isWord;
    public TrieNode[] childern;
    public String val;
    
    public TrieNode() {
        this.isWord = false;
        this.childern = new TrieNode[26];
        this.val = "";
    }
}

class Trie {
    public TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
}

class Solution {
    public HashSet<String> result;
    public char[][] board;
    public Trie wordsTrie;
    public int[][] directions;
    public List<String> findWords(char[][] board, String[] words) {
        // initialization
        result = new HashSet<String>();
        this.board = board;
        this.wordsTrie = new Trie();
        this.directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        
        // build a trie
        TrieNode root = wordsTrie.root;
        for (String w : words) {
            insertTrie(w, root);
        }
        
        // search words in the board
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (findPrefix(board[i][j], root)) {
                    // depth first search
                    boolean[][] visited = new boolean[row][col];
                    TrieNode cur = root;
                    
                    visited[i][j] = true;
                    cur = cur.childern[board[i][j] - 'a'];
                    
                    if (cur.isWord) {
                        result.add(cur.val);
                    }
                    
                    dfs(i, j, cur, visited);
                }
            }
        }
        
        // return the result
        return new ArrayList<String>(result);
    }
    
    // insert word in the trie
    private void insertTrie(String word, TrieNode root) {
        TrieNode cur = root;
        
        for (char c : word.toCharArray()) {
            if (cur.childern[c - 'a'] == null) {
                cur.childern[c - 'a'] = new TrieNode();
            }
            cur = cur.childern[c - 'a'];
        }
        cur.isWord = true;
        cur.val = word;
    }
    
    // find a word in the trie
    private boolean findPrefix(char c, TrieNode cur) {
        if (cur.childern[c - 'a'] == null) {
            return false;
        }
        return true;
    }
    
    // dfs (dfs 结构里面不包括起始点的逻辑，否则递归中会出错)
    private void dfs(int x, int y, TrieNode cur, boolean[][] visited) {
        for (int[] dir : this.directions) {
            int newx = dir[0] + x;
            int newy = dir[1] + y;
            if (inArea(newx, newy) && !visited[newx][newy] && findPrefix(board[newx][newy], cur)) {
                TrieNode pre = cur;
                cur = cur.childern[board[newx][newy] - 'a'];
                if (cur != null && cur.isWord && !result.contains(cur.val)) {
                    result.add(cur.val);
                }
                
                visited[newx][newy] = true;
                dfs(newx, newy, cur, visited);
                
                visited[newx][newy] = false;
                cur = pre; // ******* cur also need to recover
            }
        }
    }
    
    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.board.length && y >= 0 && y < this.board[0].length;
    }
}
