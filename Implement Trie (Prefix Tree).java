class TrieNode {
  char c = 0;
  Set<TrieNode> children;

  // Initialize your data structure here.
  public TrieNode() {
    this('$'); // !!
  }

  public TrieNode(char cc) {
    c = cc;
    children = new HashSet<>();
  }
}


public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    TrieNode p = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      boolean notfound = true;
      for (TrieNode child : p.children) {
        if (child.c == c) {
          p = child;
          notfound = false;
          break;
        }
      }
      if (notfound) {
        TrieNode q = new TrieNode(c);
        p.children.add(q);
        p = q;
      }
    }
    p.children.add(root);
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    TrieNode p = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      boolean notfound = true;
      for (TrieNode child : p.children) {
        if (child.c == c) {
          p = child;
          notfound = false;
          break;
        }
      }
      if (notfound)
        return false;
    }
    if (p.children.contains(root))
      return true;
    else
      return false;
  }

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public boolean startsWith(String prefix) {
    TrieNode p = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      boolean notfound = true;
      for (TrieNode child : p.children) {
        if (child.c == c) {
          p = child;
          notfound = false;
          break;
        }
      }
      if (notfound)
        return false;
    }
    return true;
  }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
