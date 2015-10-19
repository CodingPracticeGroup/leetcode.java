import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int longestConsecutive(int[] nums) {
    Map<Integer, Integer> start_end = new HashMap<>();
    Map<Integer, Integer> end_start = new HashMap<>();
    for (Integer i : nums) {
      if (start_end.containsKey(i + 1)) {
        int old_end = start_end.remove(i + 1);
        if (start_end.containsKey(i)) {
          old_end = Math.max(old_end, start_end.get(i));
        }
        start_end.put(i, old_end);
      } else if (!start_end.containsKey(i)) {
        start_end.put(i, i);
      }
      if (end_start.containsKey(i - 1)) {
        int old_start = end_start.remove(i - 1);
        if (end_start.containsKey(i)) {
          old_start = Math.min(old_start, end_start.get(i));
        }
        end_start.put(i, old_start);
      } else if (!end_start.containsKey(i)) {
        end_start.put(i, i);
      }
      if (start_end.containsKey(i) && end_start.containsKey(i)) {
        int old_end = start_end.remove(i);
        int old_start = end_start.remove(i);
        start_end.put(old_start, old_end);
        end_start.put(old_end, old_start);
      }
    }
    int max = 0;
    for (Integer start : start_end.keySet()) {
      Integer end = start_end.get(start);
      max = Math.max(max, end - start + 1);
    }
    return max;
  }
}
