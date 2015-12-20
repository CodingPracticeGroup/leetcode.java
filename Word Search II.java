import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
  // be going to process [i,j]
  void bt_trie(char[][] board, int i, int j, Map<Character, Object> trie, Set<String> ret,
      StringBuilder stack) {
    if (trie.containsKey(board[i][j])) {
      stack.append(board[i][j]);
      Map<Character, Object> next = (Map<Character, Object>) trie.get(board[i][j]);
      if (next != null) {
        board[i][j] = '#';
        if (i - 1 >= 0 && board[i - 1][j] != '#') {
          bt_trie(board, i - 1, j, next, ret, stack);
        }
        if (i + 1 < board.length && board[i + 1][j] != '#') {
          bt_trie(board, i + 1, j, next, ret, stack);
        }
        if (j - 1 >= 0 && board[i][j - 1] != '#') {
          bt_trie(board, i, j - 1, next, ret, stack);
        }
        if (j + 1 < board[0].length && board[i][j + 1] != '#') {
          bt_trie(board, i, j + 1, next, ret, stack);
        }
        //
        if (next.containsKey('$')) {
          ret.add(stack.toString());
        }
        board[i][j] = stack.charAt(stack.length() - 1);
      }
      stack.setLength(stack.length() - 1);
    }
  }

  public List<String> findWords(char[][] board, String[] words) {
    Map<Character, Object> trie_root = new HashMap<>();
    for (String w : words) {
      Map<Character, Object> node = trie_root;
      for (int i = 0; i < w.length(); i++) {
        char c = w.charAt(i);
        if (!node.containsKey(c)) {
          node.put(c, new HashMap<Character, Object>());
        }
        node = (Map<Character, Object>) node.get(c);
      }
      node.put('$', trie_root);
    }
    //
    Set<String> ret = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        bt_trie(board, i, j, trie_root, ret, new StringBuilder());
      }
    }
    return new ArrayList<String>(ret);
  }
}
