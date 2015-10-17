public class Solution {
  private void subsets_bt(int[] nums, int k, List<List<Integer>> ret, Deque<Integer> stack) {
    if (stack.size() == k) {
      List<Integer> report = new ArrayList<Integer>();
      for (Integer idx : stack) {
        report.add(nums[idx]);
      }
      Collections.sort(report);
      ret.add(report);
    } else {
      for (int i = stack.isEmpty() ? 0 : stack.peekLast() + 1; i < nums.length; i++) {
        if (nums.length - i >= k - stack.size()) {
          stack.offerLast(i);
          subsets_bt(nums, k, ret, stack);
          stack.pollLast();
        }
      }
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    for (int i = 0; i <= nums.length; i++) {
      List<List<Integer>> report = new ArrayList<>();
      subsets_bt(nums, i, report, new ArrayDeque<Integer>());
      ret.addAll(report);
    }
    return ret;
  }
}
