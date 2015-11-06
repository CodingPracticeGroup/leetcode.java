public class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums.length == 0)
      return false;
    Set<Integer> window = new HashSet<>();
    for (int i = 0; i < nums.length && i <= k; i++) {
      if (!window.add(nums[i])) {
        return true;
      }
    }
    for (int i = k + 1; i < nums.length; i++) {
      window.remove(nums[i - k - 1]);
      if (!window.add(nums[i])) {
        return true;
      }
    }
    return false;
  }
}
