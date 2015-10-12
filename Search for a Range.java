public class Solution {
  public int[] searchRange(int[] nums, int target) {
    int idx = Arrays.binarySearch(nums, target);
    if (idx < 0)
      return new int[] {-1, -1};

    int left = idx;
    int right = idx;
    for (int t = idx; (t = Arrays.binarySearch(nums, 0, t, target)) >= 0; left = t);
    for (int t = idx; (t = Arrays.binarySearch(nums, t + 1, nums.length, target)) >= 0; right = t);

    return new int[] {left, right};
  }
}
