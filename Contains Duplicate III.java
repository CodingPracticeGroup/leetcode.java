public class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (k < 1 || t < 0)
      return false;
    TreeSet<Long> window = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      Set<Long> s = window.subSet((long) nums[i] - t, true, (long) nums[i] + t, true);
      if (!s.isEmpty())
        return true;
      if (i >= k)
        window.remove((long) nums[i - k]);
      window.add((long) nums[i]);
    }
    return false;
  }
}