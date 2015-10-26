public class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (k < 1 || t < 0)
      return false;
    TreeSet<Long> window = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      Long s = window.ceiling((long) nums[i]);
      if (s != null && s - nums[i] <= t)
        return true;
      s = window.floor((long) nums[i]);
      if (s != null && nums[i] - s <= t)
        return true;
      if (i >= k)
        window.remove((long) nums[i - k]);
      window.add((long) nums[i]);
    }
    return false;
  }
}