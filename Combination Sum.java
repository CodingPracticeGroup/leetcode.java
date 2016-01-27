import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Solution {
  private void combinationSum_bt(int[] candidates, int target, List<List<Integer>> ret,
      Deque<Integer> stack) {
    if (target == 0) { // found
      List<Integer> report = new ArrayList<Integer>(stack);
      Collections.reverse(report);
      ret.add(report); // report
    } else {
      int i = 0;
      if (!stack.isEmpty()) {
        i = Arrays.binarySearch(candidates, stack.peek());
      }
      for (; i < candidates.length; i++) { // candidates
        if (target - candidates[i] >= 0) { // prune
          stack.push(candidates[i]); // forward
          combinationSum_bt(candidates, target - candidates[i], ret, stack); // explore
          stack.pop(); // backward
        }
      }
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> ret = new ArrayList<>();
    combinationSum_bt(candidates, target, ret, new ArrayDeque<Integer>());
    return ret;
  }
}
---------
public class Solution {
  private Set<List<Integer>> c(int[] candidates, int target, int start) {
    Set<List<Integer>> ret = new HashSet<>();
    if (start >= candidates.length) {
      return ret;
    }
    if (start < candidates.length && candidates[start] > target) {
      return ret;
    }
    if (start < candidates.length && target == candidates[start]) {
      List<Integer> l = new ArrayList<>();
      l.add(candidates[start]);
      ret.add(l);
      return ret;
    }
    Set<List<Integer>> s_start = c(candidates, target - candidates[start], start); // to be
    for (List<Integer> l : s_start) {
      l.add(0, candidates[start]);
    }
    Set<List<Integer>> s_start1 = c(candidates, target, start + 1); // not to be
    ret.addAll(s_start);
    ret.addAll(s_start1);
    return ret;
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    return new ArrayList<List<Integer>>(c(candidates, target, 0));
  }
}
