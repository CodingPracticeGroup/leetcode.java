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

  public boolean containsNearbyDuplicate_(int[] nums, int k) {
    Set<Integer> window = new HashSet<>();
    for (int i = 0; i < Math.min(k + 1, nums.length); i++) {
      if (window.contains(nums[i])) {
        return true;
      }
      window.add(nums[i]);
    }
    for (int i = k + 1; i < nums.length; i++) {
      window.remove(nums[i - k - 1]);
      if (window.contains(nums[i])) {
        return true;
      }
      window.add(nums[i]);
    }
    return false;
  }
}
---------------------
public class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> window = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (i > k) { // 双idx拉window一遍scan不停
        window.remove(nums[i - k - 1]);
      }
      if (!window.add(nums[i]))
        return true;
    }
    return false;
  }
}
