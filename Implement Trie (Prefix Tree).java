import java.util.HashMap;
import java.util.Map;

class TrieNode {
  Map<Character, TrieNode> children;

  // Initialize your data structure here.
  public TrieNode() {
    children = new HashMap<>();
  }
}


public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    TrieNode tn = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!tn.children.containsKey(c)) {
        tn.children.put(c, new TrieNode());
      }
      tn = tn.children.get(c);
    }
    tn.children.put('$', root);
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    TrieNode tn = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!tn.children.containsKey(c)) {
        return false;
      }
      tn = tn.children.get(c);
    }
    return tn.children.containsKey('$');
  }

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public boolean startsWith(String prefix) {
    TrieNode tn = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (!tn.children.containsKey(c)) {
        return false;
      }
      tn = tn.children.get(c);
    }
    return true;
  }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
