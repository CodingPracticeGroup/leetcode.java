public class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i <= k && i < nums.length; i++) {
      if (seen.contains(nums[i]))
        return true;
      else
        seen.add(nums[i]);
    }
    for (int i = k + 1; i < nums.length; i++) {
      seen.remove(nums[i - k - 1]);
      if (seen.contains(nums[i]))
        return true;
      else
        seen.add(nums[i]);
    }
    return false;
  }
}
