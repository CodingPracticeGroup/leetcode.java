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
