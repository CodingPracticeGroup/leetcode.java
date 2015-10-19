public class Solution {
  private void findLadders_parents(Map<String, Set<String>> map, String child, String parent) {
    if (map.containsKey(child)) {
      Set<String> parents = map.get(child);
      parents.add(parent);
    } else {
      Set<String> parents = new HashSet<>();
      parents.add(parent);
      map.put(child, parents);
    }
  }

  private Map<String, Set<String>> findLadders_bfs(String beginWord, String endWord,
      Set<String> wordList) {
    Map<String, Set<String>> parentmap = new HashMap<>(); // backtracking
    Set<String> queue = new HashSet<>(); // offer/poll too slow
    queue.add(beginWord); // enqueue
    while (!queue.isEmpty()) {
      wordList.removeAll(queue); // visited
      Set<String> newqueue = new HashSet<>();
      for (String str : queue) { // level
        for (int j = 0; j < str.length(); j++) { // candidates
          StringBuilder newstrsb = new StringBuilder(str);
          for (char c = 'a'; c <= 'z'; c++) {
            newstrsb.setCharAt(j, c);
            String newstr = newstrsb.toString();
            if (wordList.contains(newstr)) { // visited prune
              newqueue.add(newstr); // enqueue
              findLadders_parents(parentmap, newstr, str);
            }
          }
        }
      }
      queue = newqueue;
      if (parentmap.containsKey(endWord)) {
        return parentmap;
      }
    }
    return new HashMap<String, Set<String>>();
  }

  private List<List<String>> findLadders_bt(String beginWord, String endWord,
      Map<String, Set<String>> parentmap) {
    List<List<String>> ret = new LinkedList<>();

    List<String> path = new LinkedList<>();
    path.add(endWord);
    ret.add(path);
    if (beginWord.equals(endWord)) {
      return ret;
    }
    if (parentmap.isEmpty()) {
      return new ArrayList<List<String>>();
    }

    boolean notfound = true;
    while (notfound) {
      List<List<String>> newret = new LinkedList<>();
      for (List<String> l : ret) {
        Set<String> s = parentmap.get(l.get(0));
        for (String str : s) {
          if (str.equals(beginWord)) {
            notfound = false;
          }
          List<String> newl = new LinkedList<>(l);
          newl.add(0, str);
          newret.add(newl);
        }
      }
      ret = newret;
    }
    return ret;
  }

  public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    wordList.add(beginWord);
    wordList.add(endWord);

    Map<String, Set<String>> parentmap = findLadders_bfs(beginWord, endWord, wordList);
    List<List<String>> ret = findLadders_bt(beginWord, endWord, parentmap);

    return ret;
  }
}
