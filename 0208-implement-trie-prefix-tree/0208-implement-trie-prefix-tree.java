class TrieNode {
    TrieNode[] links = new TrieNode[26];
    boolean flag = false;

    TrieNode() {

    }

    boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }

}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;

        for(char w : word.toCharArray()) {
            if(!node.contains(w)) {
                node.links[w - 'a'] = new TrieNode();
            } 
            node = node.links[w-'a'];
        }
        node.flag = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;

        for(char w : word.toCharArray()) {
            if(!node.contains(w)) {
                return false;
            }
            node = node.links[w - 'a'];
        }

        return node.flag;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for(char ch : prefix.toCharArray()) {
            if(!node.contains(ch)) {
                return false;
            }
            node = node.links[ch - 'a'];
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