public class Solution {
  private void combine_bt(int n, int k, int start, Deque<Integer> stack, List<List<Integer>> ret) {
    if (stack.size() == k) {
      ret.add(new ArrayList<Integer>(stack));
    } else {
      for (int i = start; i <= n; i++) {
        if (n - i + 1 >= k - stack.size()) {
          stack.offerLast(i);
          combine_bt(n, k, i + 1, stack, ret);
          stack.pollLast();
        }
      }
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ret = new ArrayList<>();
    combine_bt(n, k, 1, new ArrayDeque<Integer>(), ret);
    return ret;
  }
}
