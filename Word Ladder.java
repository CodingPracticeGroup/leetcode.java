public class Solution {
  public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    wordList.add(beginWord);
    wordList.add(endWord);
    Set<String> queue = new HashSet<>();
    queue.add(beginWord);
    int count = 2;
    while (!queue.isEmpty()) {
      wordList.removeAll(queue);
      Set<String> newqueue = new HashSet<>();
      for (String str : queue) {
        for (int i = 0; i < str.length(); i++) {
          StringBuilder sb = new StringBuilder(str);
          for (char c = 'a'; c <= 'z'; c++) {
            sb.setCharAt(i, c);
            String newstr = sb.toString();
            if (newstr.equals(endWord)) {
              return count;
            }
            if (wordList.contains(newstr)) {
              newqueue.add(newstr);
            }
          }
        }
      }
      queue = newqueue;
      count++;
    }
    return 0;
  }
}
------------
public class Solution {
  public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    int ret = 1;
    Set<String> visited = new HashSet<>(); // mark
    Deque<String> queue = new ArrayDeque<>(); // queue
    visited.add(beginWord);
    queue.offer(beginWord);
    while (!queue.isEmpty()) {
      ret++;
      int count = queue.size(); // level
      for (int j = 0; j < count; j++) {
        char[] nc = queue.poll().toCharArray(); // poll
        for (int i = 0; i < nc.length; i++) { // explorer
          char orig = nc[i];
          for (char c = 'a'; c <= 'z'; c++) { // explorer
            if (c != orig) { // prune
              nc[i] = c;
              String s = new String(nc); // construct
              if (s.equals(endWord)) {
                return ret;
              }
              if (wordList.contains(s) && !visited.contains(s)) { // prune
                visited.add(s);
                queue.offer(s);
              }
            }
          }
          nc[i] = orig;
        }
      }
    }
    return 0;
  }
}
