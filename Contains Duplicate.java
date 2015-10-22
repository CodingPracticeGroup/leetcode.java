public class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (seen.contains(nums[i]))
        return true;
      else
        seen.add(nums[i]);
    }
    return false;
  }
}
