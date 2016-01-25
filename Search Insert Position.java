public class Solution {
  public int searchInsert(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (target < nums[mid]) {
        high = mid - 1; // move
      } else if (nums[mid] < target) {
        low = mid + 1; // move
      } else {
        return mid;
      }
    }
    return low;
  }

  public int searchInsert_(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      // low <= insertion <= high
      if (low == high) {
        if (nums[low] < target) {
          return low + 1;
        } else if (target < nums[low]) {
          return low;
        } else {
          return low;
        }
      }
      int mid = low + (high - low) / 2;
      if (target < nums[mid]) {
        high = mid; // does not move
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        return mid;
      }
    }
    return low;
  }
}
