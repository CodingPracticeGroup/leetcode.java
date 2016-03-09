public class Solution {
  private void combinationSum2_bt(int[] candidates, int target, Set<List<Integer>> ret,
      Deque<Integer> stack, int start) {
    if (target == 0) { // found
      List<Integer> report = new ArrayList<>(stack);
      Collections.reverse(report);
      ret.add(report); // report
    } else {
      for (int i = start; i < candidates.length; i++) { // candidates
        if (target - candidates[i] >= 0) { // prune
          stack.push(candidates[i]); // forward
          combinationSum2_bt(candidates, target - candidates[i], ret, stack, i + 1); // recursion
          stack.pop(); // backward
        }
      }
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    Set<List<Integer>> ret = new HashSet<>();
    combinationSum2_bt(candidates, target, ret, new ArrayDeque<Integer>(), 0);
    return new ArrayList<List<Integer>>(ret);
  }
}
-----------
public class Solution {
  private Set<List<Integer>> c(int[] candidates, int start, int target) {
    Set<List<Integer>> ret = new HashSet<>(); // return
    if (target == 0) { // termination
      ret.add(new LinkedList<Integer>()); // termination item
      return ret;
    }
    for (int i = start; i < candidates.length; i++) { // explore
      if (target - candidates[i] >= 0) { // prune
        Set<List<Integer>> r = c(candidates, i + 1, target - candidates[i]); // dfs recursion
        for (List<Integer> l : r) { // iteration children result
          l.add(0, candidates[i]); // construct one result of current node
          ret.add(l); // add to current result
        }
      }
    }
    return ret; // default termination only
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    return new ArrayList<List<Integer>>(c(candidates, 0, target));
  }
}
---------------
public class Solution {
  Set<List<Integer>> c(int[] candidates, int startPos, int target) {
    Set<List<Integer>> ret = new HashSet<>(); // return

    if (target == 0) { // termination item
      List<Integer> l = new ArrayList<>();
      ret.add(l);
      return ret;
    }
    if (startPos == candidates.length) {// termination only
      return ret;
    }

    for (int i = startPos; i < candidates.length && candidates[i] <= target; i++) { // branch & prune
      Set<List<Integer>> r = c(candidates, i + 1, target - candidates[i]); // dfs recursion
      for (List<Integer> l : r) { // iteration children result
        l.add(0, candidates[i]);// construct
        ret.add(l); // add to current result
      }
    }

    return ret;
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
	// 这里的set去重复还是要的。。因为那个入口的数组本来就是重复的，用set去重复比较好写，不然就得treemap对每个元素计数
    return new ArrayList<List<Integer>>(c(candidates, 0, target));
  }
}
