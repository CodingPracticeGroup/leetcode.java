public class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeMap<Long, Integer> window = new TreeMap<>(); // n * log k
    for (int i = 0; i < nums.length; i++) {
      if (i - k - 1 >= 0) {
        window.put((long) nums[i - k - 1], window.get((long) nums[i - k - 1]) - 1);
        if (window.get((long) nums[i - k - 1]) == 0) {
          window.remove((long) nums[i - k - 1]);
        }
      }
      //
      Long floor = window.floorKey((long) nums[i]);
      if (floor != null && nums[i] - floor <= t) {
        return true;
      }
      Long ceiling = window.ceilingKey((long) nums[i]);
      if (ceiling != null && ceiling - nums[i] <= t) {
        return true;
      }
      //
      if (!window.containsKey((long) nums[i])) {
        window.put((long) nums[i], 0);
      }
      window.put((long) nums[i], window.get((long) nums[i]) + 1);
    }
    return false;
  }
}
