public class Solution {
  void bt(int k, int n, List<List<Integer>> ret, LinkedList<Integer> stack) {
    if (k == 0 && n == 0) {
      ret.add(new ArrayList<Integer>(stack));
    } else {
      if (k <= 0 || n <= 0) {
        return;
      }
      int last = 0;
      if (!stack.isEmpty()) {
        last = stack.peekLast();
      }
      for (int i = last + 1; i <= 9; i++) {
        stack.offerLast(i);
        bt(k - 1, n - i, ret, stack);
        stack.pollLast();
      }
    }
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ret = new ArrayList<>();
    bt(k, n, ret, new LinkedList<Integer>());
    return ret;
  }
}
