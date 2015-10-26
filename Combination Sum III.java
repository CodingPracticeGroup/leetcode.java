public class Solution {
  private void combinationSum3_bt(int k, int n, List<List<Integer>> ret, Deque<Integer> stack) {
    if (n == 0 && stack.size() == k) { // report
      ret.add(new ArrayList<Integer>(stack));
    } else {
      if (n <= 0 || stack.size() >= k)
        return; // prune
      int start = stack.isEmpty() ? 1 : stack.peekLast() + 1;
      if (start > n)
        return; // prune
      for (int i = start; i <= 9; i++) {
        if (i <= n) { // prune
          stack.offerLast(i);
          combinationSum3_bt(k, n - i, ret, stack);
          stack.pollLast();
        }
      }
    }
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ret = new ArrayList<>();
    combinationSum3_bt(k, n, ret, new ArrayDeque<Integer>());
    return ret;
  }
}
