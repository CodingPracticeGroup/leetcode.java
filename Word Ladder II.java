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
              findLadders_parents(parentmap, newstr, str); // parent.computeIfAbsent(nn, k -> new HashSet<String>()).add(s);
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
-------------------------
public class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    Map<String, Set<String>> parent = new HashMap<>();
    Set<String> visited = new HashSet<>();
    Set<String> queue = new HashSet<>();

    int count = 0;
    parent.put(beginWord, new HashSet<String>());
    queue.add(beginWord);
    visited.addAll(queue);
    while (!queue.isEmpty()) { // bfs level
      Set<String> next = new HashSet<>();
      for (String s : queue) {
        char[] n = s.toCharArray(); // string->char array
        for (int j = 0; j < n.length; j++) {
          char old = n[j];
          for (char c = 'a'; c <= 'z'; c++) {
            if (c != old) {
              n[j] = c;
              String nn = new String(n);
              if (wordList.contains(nn) && !visited.contains(nn)) {
                parent.computeIfAbsent(nn, k -> new HashSet<String>()).add(s);
                next.add(nn);
              }
            }
          }
          n[j] = old;
        }
      }
      if (next.contains(endWord))
        break;
      queue = next;
      visited.addAll(queue);
      count++;
    }

    List<List<String>> ret = new ArrayList<>();
    if (!parent.containsKey(endWord))
      return ret;
    LinkedList<String> one = new LinkedList<>();
    one.offerFirst(endWord);
    ret.add(one);
    for (int i = 0; i <= count; i++) { // link parent
      List<List<String>> ret2 = new ArrayList<>();
      for (List<String> l : ret) {
        for (String w : parent.get(l.get(0))) {
          LinkedList<String> ll = new LinkedList<>(l);
          ll.offerFirst(w);
          ret2.add(ll);
        }
      }
      ret = ret2;
    }
    return ret;
  }
}
-------------------
public class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    Map<String, Set<String>> parents = new HashMap<>();
    Set<String> tabu = new HashSet<>();
    Set<String> queue = new HashSet<>();
    tabu.add(beginWord);
    queue.add(beginWord);
    boolean found = false;
    while (!queue.isEmpty()) {
      Set<String> nextQueue = new HashSet<>();
      for (String sss : queue) {
        char[] arr = sss.toCharArray();
        for (int j = 0; j < arr.length; j++) {
          char c = arr[j];
          for (char cc = 'a'; cc <= 'z'; cc++) { // push
            if (cc != c) {
              arr[j] = cc;
              String s = new String(arr);
              if (wordList.contains(s) && !tabu.contains(s)) {
                if (s.equals(endWord))
                  found = true;
                nextQueue.add(s);
                parents.computeIfAbsent(s, k -> new HashSet<String>()).add(sss);
              }
            }
          }
          arr[j] = c; // pop
        }
      }
      queue = nextQueue;
      tabu.addAll(queue);
      if (found)
        break;
    }
    List<List<String>> ret = new ArrayList<>();
    if (!found)
      return ret;
    LinkedList<String> l = new LinkedList<>();
    l.offerFirst(endWord);
    ret.add(l);
    boolean built = false;
    while (!built) {
      List<List<String>> ret2 = new ArrayList<>();
      for (List<String> ll : ret) {
        if (parents.containsKey(ll.get(0))) {
          for (String ss : parents.get(ll.get(0))) {
            if (ss.equals(beginWord))
              built = true;
            LinkedList<String> ll2 = new LinkedList<>(ll);
            ll2.offerFirst(ss);
            ret2.add(ll2);
          }
        }
      }
      ret = ret2;
    }
    return ret;
  }
}
