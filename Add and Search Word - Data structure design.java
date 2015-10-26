class Node {
  Map<Character, Node> children;

  public Node() {
    children = new HashMap<>();
  }
}


public class WordDictionary {
  Node root;

  public WordDictionary() {
    root = new Node();
  }

  // Adds a word into the data structure.
  public void addWord(String word) {
    Node p = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (p.children.containsKey(c)) {
        p = p.children.get(c);
      } else {
        Node q = new Node();
        p.children.put(c, q);
        p = q;
      }
    }
    p.children.put('$', root);
  }

  private boolean search(String word, int start, Node p) {
    if (start == word.length()) {
      if (p.children.containsKey('$'))
        return true;
      else
        return false;
    } else {
      char c = word.charAt(start);
      if (c == '.') {
        for (Node n : p.children.values()) {
          if (n != root && search(word, start + 1, n))
            return true;
        }
        return false;
      } else {
        if (p.children.containsKey(c))
          return search(word, start + 1, p.children.get(c));
        else
          return false;
      }
    }
  }

  // Returns if the word is in the data structure. A word could
  // contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    return search(word, 0, root);
  }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
