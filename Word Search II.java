public class Solution {
  class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
  }

  private TrieNode findWords_build(String[] words) {
    TrieNode root = new TrieNode();
    for (String s : words) {
      TrieNode p = root;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (!p.children.containsKey(c))
          p.children.put(c, new TrieNode());
        p = p.children.get(c);
      }
      p.children.put('$', root);
    }
    return root;
  }

  private void findWords_bt(char[][] board, int i, int j, TrieNode p, Set<List<Character>> ret,
      Deque<Character> stack) {
    if (p.children.containsKey('$')) {
      ret.add(new ArrayList<Character>(stack));
    }
    if (i >= 0 && i < board.length && j >= 0 && j < board[0].length
        && p.children.containsKey(board[i][j])) {
      stack.offerLast(board[i][j]);
      board[i][j] = '#';
      findWords_bt(board, i - 1, j, p.children.get(stack.peekLast()), ret, stack);
      findWords_bt(board, i, j - 1, p.children.get(stack.peekLast()), ret, stack);
      findWords_bt(board, i + 1, j, p.children.get(stack.peekLast()), ret, stack);
      findWords_bt(board, i, j + 1, p.children.get(stack.peekLast()), ret, stack);
      board[i][j] = stack.pollLast();
    }
  }

  public List<String> findWords(char[][] board, String[] words) {
    TrieNode root = findWords_build(words);
    Set<String> ret = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        Set<List<Character>> collection = new HashSet<>();
        findWords_bt(board, i, j, root, collection, new ArrayDeque<Character>());
        for (List<Character> l : collection) {
          ret.add(l.stream().map(c -> c.toString()).reduce("", (acc, e) -> acc + e));
        }
      }
    }
    return new ArrayList<String>(ret);
  }
}