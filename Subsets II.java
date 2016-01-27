public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> ret = new HashSet<>();
    ret.add(new ArrayList<Integer>());
    for (int i = 0; i < nums.length; i++) {
      Set<List<Integer>> round = new HashSet<>();
      for (List<Integer> l : ret) {
        List<Integer> duplicate = new ArrayList<>(l);
        duplicate.add(nums[i]);
        round.add(duplicate);
      }
      ret.addAll(round);
    }
    return new ArrayList<List<Integer>>(ret);
  }
}
----------
public class Solution {
  private Set<List<Integer>> s(int[] nums, int start) {
    Set<List<Integer>> ret = new HashSet<>();
    ret.add(new ArrayList<Integer>());
    if (start >= nums.length) {
      return ret;
    }
    for (int i = start; i < nums.length; i++) { // pick nums[i]
      Set<List<Integer>> r = s(nums, i + 1);
      for (List<Integer> l : r) {
        l.add(0, nums[i]);
      }
      ret.addAll(r);
    }
    return ret;
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    return new ArrayList<List<Integer>>(s(nums, 0));
  }
}
