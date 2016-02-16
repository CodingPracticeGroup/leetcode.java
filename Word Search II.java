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
--------------
public class Solution {
  Map<Character, Object> root = new HashMap<>(); // one char per link

  private void addWord(String w) {
    Map<Character, Object> p = root;
    for (int i = 0; i < w.length(); i++) {
      p.computeIfAbsent(w.charAt(i), k -> new HashMap<Character, Object>());
      p = (Map<Character, Object>) p.get(w.charAt(i));
    }
    p.computeIfAbsent('$', k -> root);
  }

  int[][] dirs = new int[][] {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};

  private void dfs(char[][] board, Map<Character, Object> root, int i, int j, Set<String> ret,
      StringBuilder path) {
    char c = board[i][j];
    if (root.containsKey(c)) {
      path.append(c);
      board[i][j] = '#'; // stack

      Map<Character, Object> next = (Map<Character, Object>) root.get(c);
      if (next.containsKey('$')) { // found
        ret.add(path.toString());
      }

      for (int[] dir : dirs) { // explore
        int x = i + dir[0];
        int y = j + dir[1];
        if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] != '#') {
          dfs(board, next, x, y, ret, path);
        }
      }

      board[i][j] = c; // stack
      path.setLength(path.length() - 1);
    }
  }

  public List<String> findWords(char[][] board, String[] words) {
    for (String w : words) {
      addWord(w);
    }
    Set<String> ret = new HashSet<>();
    int m = board.length;
    int n = board[0].length;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        sb.setLength(0);
        dfs(board, root, i, j, ret, sb);
      }
    }
    return new ArrayList<String>(ret);
  }
}
