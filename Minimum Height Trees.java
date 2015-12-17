import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
