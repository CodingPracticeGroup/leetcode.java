public class Solution {
  private void permuteUnique_bt(int[] nums, Set<Integer> idx, Set<List<Integer>> ret,
      Deque<Integer> stack) {
    if (idx.isEmpty()) {
      ret.add(new ArrayList<Integer>(stack));
    } else {
      Set<Integer> tabu = new HashSet<>();
      for (Integer i : idx) {
        if (!tabu.contains(nums[i])) {
          stack.push(nums[i]);
          Set<Integer> forchild = new HashSet<>(idx);
          forchild.remove(i);
          permuteUnique_bt(nums, forchild, ret, stack);
          stack.pop();
          tabu.add(nums[i]);
        }
      }
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    Set<List<Integer>> ret = new HashSet<>();
    Set<Integer> idx = new HashSet<>();
    // IntStream.range(0, nums.length).boxed().collect(Collectors.toSet());
    for (int i = 0; i < nums.length; i++) {
      idx.add(i);
    }

    permuteUnique_bt(nums, idx, ret, new ArrayDeque<Integer>());
    return new ArrayList<List<Integer>>(ret);
  }
}
