import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
  public List<int[]> getSkyline(int[][] buildings) {
    TreeMap<Integer, Map<Integer, Integer>> idx_heightAction_count = new TreeMap<>();
    for (int[] b : buildings) {
      // create index
      if (!idx_heightAction_count.containsKey(b[0])) {
        idx_heightAction_count.put(b[0], new TreeMap<Integer, Integer>());
      }
      if (!idx_heightAction_count.containsKey(b[1])) {
        idx_heightAction_count.put(b[1], new TreeMap<Integer, Integer>());
      }
      // increase height at index 0
      if (!idx_heightAction_count.get(b[0]).containsKey(b[2])) {
        idx_heightAction_count.get(b[0]).put(b[2], 0);
      }
      int old = idx_heightAction_count.get(b[0]).get(b[2]);
      idx_heightAction_count.get(b[0]).put(b[2], old + 1);
      // decrease height at index 1
      if (!idx_heightAction_count.get(b[1]).containsKey(-b[2])) {
        idx_heightAction_count.get(b[1]).put(-b[2], 0);
      }
      old = idx_heightAction_count.get(b[1]).get(-b[2]);
      idx_heightAction_count.get(b[1]).put(-b[2], old + 1);
    }

    TreeMap<Integer, Integer> active_height = new TreeMap<>();
    List<int[]> ret = new ArrayList<>();
    int last_height = 0;
    for (Map.Entry<Integer, Map<Integer, Integer>> e : idx_heightAction_count.entrySet()) {
      // for each idx
      int idx = e.getKey();
      Map<Integer, Integer> actionHeight_count = e.getValue();
      for (Map.Entry<Integer, Integer> ee : actionHeight_count.entrySet()) {
        // for each height action
        int actionHeight = ee.getKey();
        int count = ee.getValue();
        if (actionHeight < 0) {
          int old = active_height.get(-actionHeight);
          if (old - count == 0) {
            active_height.remove(-actionHeight);
          } else {
            active_height.put(-actionHeight, old - count);
          }
        } else {
          if (!active_height.containsKey(actionHeight)) {
            active_height.put(actionHeight, 0);
          }
          int old = active_height.get(actionHeight);
          active_height.put(actionHeight, old + count);
        }
      }
      // judge after processing actions for each idx
      if (active_height.isEmpty()) {
        ret.add(new int[] {idx, 0});
      } else {
        int cur = active_height.lastKey();
        if (cur != last_height) {
          ret.add(new int[] {idx, cur});
          last_height = cur;
        }
      }
    }
    return ret;
  }
}
