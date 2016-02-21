public class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    Map<Integer, Set<Integer>> adj = new HashMap<>();
    for (int i = 0; i < n; i++) {
      adj.put(i, new HashSet<>());
    }
    for (int[] e : edges) {
      adj.get(e[0]).add(e[1]);
      adj.get(e[1]).add(e[0]);
    }
    while (adj.size() > 2) {
      Set<Integer> s = new HashSet<>();
      for (Integer i : adj.keySet()) {
        if (adj.get(i).size() == 1) {
          s.add(i);
        }
      }
      for (Integer i : s) {
        for (int p : adj.get(i)) {
          adj.get(p).remove(i);
        }
        adj.remove(i);
      }
    }
    return new ArrayList<Integer>(adj.keySet());
  }
}
----------------
public class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    Map<Integer, Set<Integer>> adj = new HashMap<>();
    for (int i = 0; i < n; i++) {
      adj.put(i, new HashSet<Integer>());
    }
    for (int[] e : edges) {
      adj.get(e[0]).add(e[1]);
      adj.get(e[1]).add(e[0]);
    }

    Deque<Integer> leaves = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (adj.get(i).size() == 1) {
        leaves.offer(i);
      }
    }
    while (adj.size() > 2) {
      int count = leaves.size();
      for (int i = 0; i < count; i++) {
        int idx = leaves.poll();
        for (Integer peer : adj.get(idx)) {
          adj.get(peer).remove(idx);
          if (adj.get(peer).size() == 1) {
            leaves.offer(peer);
          }
        }
        adj.remove(idx);
      }
    }
    return new ArrayList<Integer>(adj.keySet());
  }
}
--------------------
public class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    Map<Integer, Set<Integer>> adj = new HashMap<>();
    for (int i = 0; i < n; i++) {
      adj.put(i, new HashSet<Integer>());
    }
    Set<Integer> leaf = new HashSet<>(); // 标准的bfs砍枝
    for (int[] e : edges) {
      adj.get(e[0]).add(e[1]);
      adj.get(e[1]).add(e[0]);
      if (adj.get(e[0]).size() == 1)
        leaf.add(e[0]);
      else
        leaf.remove(e[0]);
      if (adj.get(e[1]).size() == 1)
        leaf.add(e[1]);
      else
        leaf.remove(e[1]);
    }
    while (adj.size() > 2) {
      Set<Integer> nextLeaf = new HashSet<>();
      for (Integer l : leaf) {
        for (Integer p : adj.get(l)) {
          adj.get(p).remove(l);
          if (adj.get(p).size() == 1)
            nextLeaf.add(p);
        }
        adj.remove(l);
      }
      leaf = nextLeaf;
    }
    return new ArrayList<Integer>(adj.keySet());
  }
}
