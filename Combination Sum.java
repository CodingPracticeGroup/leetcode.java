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
