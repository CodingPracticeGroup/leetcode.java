public class Solution {
  private void permute_bt(int[] orig_nums, Set<Integer> idx, List<List<Integer>> ret,
      Deque<Integer> stack) {
    if (idx.isEmpty()) {
      ret.add(new ArrayList<Integer>(stack));
    } else {
      for (Integer i : idx) {
        stack.push(orig_nums[i]);
        Set<Integer> forchild = new HashSet<>(idx); // necessary, otherwise Line 7: java.util.ConcurrentModificationException
        forchild.remove(i);
        permute_bt(orig_nums, forchild, ret, stack);
        stack.pop();
      }
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    permute_bt(nums, IntStream.range(0, nums.length).boxed().collect(Collectors.toSet()), ret,
        new ArrayDeque<Integer>());
    return ret;
  }

  private Set<List<Integer>> p(int[] nums, int start, int end) {
    Set<List<Integer>> ret = new HashSet<>();
    if (start + 1 == end) {
      List<Integer> l = new ArrayList<>();
      l.add(nums[start]);
      ret.add(l);
      return ret;
    }
    Set<List<Integer>> s = p(nums, start + 1, end);
    for (List<Integer> l : s) {
      for (int i = 0; i <= l.size(); i++) {
        List<Integer> ll = new ArrayList<>(l);
        ll.add(i, nums[start]);
        ret.add(ll);
      }
    }
    return ret;
  }

  public List<List<Integer>> permute_(int[] nums) {
    return new ArrayList<List<Integer>>(p(nums, 0, nums.length));
  }
}
