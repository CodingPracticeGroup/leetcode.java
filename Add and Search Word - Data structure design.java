import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
  Map<Character, Object> root = new HashMap<>();

  // Adds a word into the data structure.
  public void addWord(String word) {
    Map<Character, Object> node = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!node.containsKey(c)) {
        node.put(c, new HashMap<Character, Object>());
      }
      node = (Map<Character, Object>) node.get(c);
    }
    node.put('$', root);
  }

  boolean search_internal(String word, int start, Map<Character, Object> node) {
    if (start == word.length()) {
      return node.containsKey('$');
    }
    char c = word.charAt(start);
    if (c == '.') {
      for (Object o : node.values()) {
        if (o != root && search_internal(word, start + 1, (Map<Character, Object>) o)) {
          return true;
        }
      }
    } else if (node.containsKey(c)) {
      return search_internal(word, start + 1, (Map<Character, Object>) node.get(c));
    }
    return false;
  }

  // Returns if the word is in the data structure. A word could
  // contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    return search_internal(word, 0, root);
  }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
