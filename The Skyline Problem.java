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
------------------
public class Solution {
  public List<int[]> getSkyline(int[][] buildings) {
    TreeMap<Integer, Integer> activeHeightCount = new TreeMap<>();
    TreeMap<Integer, List<Integer>> idxAction = new TreeMap<>();
    for (int[] b : buildings) {
      if (!idxAction.containsKey(b[0])) {
        idxAction.put(b[0], new ArrayList<Integer>());
      }
      idxAction.get(b[0]).add(b[2]);
      if (!idxAction.containsKey(b[1])) {
        idxAction.put(b[1], new ArrayList<Integer>());
      }
      idxAction.get(b[1]).add(-b[2]);
    }
    LinkedList<int[]> ret = new LinkedList<>();
    for (Integer idx : idxAction.keySet()) {
      List<Integer> actions = idxAction.get(idx);
      actions.sort((x, y) -> x - y);
      for (Integer a : actions) {
        if (a < 0) {
          activeHeightCount.put(-a, activeHeightCount.get(-a) - 1);
          if (activeHeightCount.get(-a) == 0) {
            activeHeightCount.remove(-a);
          }
        } else {
          if (!activeHeightCount.containsKey(a)) {
            activeHeightCount.put(a, 0);
          }
          activeHeightCount.put(a, activeHeightCount.get(a) + 1);
        }
      }
      if (ret.isEmpty()) {
        if (!activeHeightCount.isEmpty()) {
          ret.offerLast(new int[] {idx, activeHeightCount.lastKey()});
        }
      } else {
        if (activeHeightCount.isEmpty()) {
          ret.offerLast(new int[] {idx, 0});
        } else {
          if (ret.peekLast()[1] != activeHeightCount.lastKey()) {
            ret.offerLast(new int[] {idx, activeHeightCount.lastKey()});
          }
        }
      }
    }
    return ret;
  }
}
----------------
public class Solution {
  public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> result = new ArrayList<>(); // ret
    List<int[]> height = new ArrayList<>(); // sort input array
    for (int[] b : buildings) {
      height.add(new int[] {b[0], -b[2]}); // start point has negative height value
      height.add(new int[] {b[1], b[2]}); // end point has normal height value
    }

    // sort $height, based on the first value, if necessary, use the second to break ties
    Collections.sort(height, (a, b) -> {
      if (a[0] != b[0])
        return a[0] - b[0];
      return a[1] - b[1];
    });

    // Use a maxHeap to store possible heights
    Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

    // Provide a initial value to make it more consistent
    pq.offer(0);

    // Before starting, the previous max height is 0;
    int prev = 0;

    // visit all points in order
    for (int[] h : height) {
      if (h[1] < 0) { // a start point, add height
        pq.offer(-h[1]);
      } else { // a end point, remove height
        pq.remove(h[1]);
      }
      int cur = pq.peek(); // current max height;

      // compare current max height with previous max height, update result and previous max height
      // if necessary
      if (prev != cur) {
        result.add(new int[] {h[0], cur});
        prev = cur;
      }
    }
    return result;
  }
}
