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
-----------
public class Solution {
  private int l(int[] n, int t) {
    int low = 0;
    int high = n.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (n[mid] < t) {
        low = mid + 1;
      } else if (n[mid] > t) {
        high = mid - 1;
      } else {
        high = mid;
      }
    }
    if (n[low] == t)
      return low;
    else
      return -1;
  }

  private int r(int[] n, int t) {
    int low = 0;
    int high = n.length - 1;
    while (low < high) {
      int mid = low + (int) Math.ceil((high - low) / 2.0);
      if (n[mid] < t) {
        low = mid + 1;
      } else if (n[mid] > t) {
        high = mid - 1;
      } else {
        low = mid;
      }
    }
    if (n[high] == t)
      return high;
    else
      return -1;
  }

  public int[] searchRange(int[] nums, int target) {
    return new int[] {l(nums, target), r(nums, target)};
  }
}
