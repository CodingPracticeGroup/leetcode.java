public class Solution {
  private void permute_bt(int[] orig_nums, Set<Integer> idx, List<List<Integer>> ret,
      Deque<Integer> stack) {
    if (idx.isEmpty()) {
      ret.add(new ArrayList<Integer>(stack));
    } else {
      for (Integer i : idx) {
        stack.push(orig_nums[i]);
        Set<Integer> forchild = new HashSet<>(idx);
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
}
