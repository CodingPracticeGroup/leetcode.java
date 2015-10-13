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
