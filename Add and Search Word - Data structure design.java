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
----------------------
public class WordDictionary {
  HashMap<Character, HashMap> root = new HashMap<>();

  // Adds a word into the data structure.
  public void addWord(String word) {
    HashMap<Character, HashMap> p = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!p.containsKey(c)) {
        p.put(c, new HashMap<Character, HashMap>());
      }
      p = p.get(c);
    }
    p.put('$', root);
  }

  private boolean s(String word, int startPos, HashMap<Character, HashMap> p) {
    if (startPos == word.length()) {
      if (p.containsKey('$') && p.get('$') == root) {
        return true;
      } else {
        return false;
      }
    }
    char c = word.charAt(startPos); // 这个是最后一根稻草，节约时间
    if (c == '.') {
      for (HashMap o : p.values()) { // 直接遍历values，比遍历keySet节约时间
        if (o != root && s(word, startPos + 1, o)) {
          return true;
        }
      }
      return false;
    } else if (p.containsKey(c)) {
      return s(word, startPos + 1, p.get(c));
    } else {
      return false;
    }
  }

  // Returns if the word is in the data structure. A word could
  // contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    return s(word, 0, root);
  }
}