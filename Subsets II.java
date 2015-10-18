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
