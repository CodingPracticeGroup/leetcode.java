public class Solution {
  private int findMin_range(int[] nums, int start, int end) {
    if (start + 1 == end)
      return nums[start];
    if (start + 2 == end)
      return Math.min(nums[start], nums[start + 1]);
    int mid = (start + end) / 2;
    if (nums[start] < nums[mid]) {
      return Math.min(nums[start], findMin_range(nums, mid + 1, end));
    } else {// nums[mid]<nums[right]
      return Math.min(nums[mid], findMin_range(nums, start, mid));
    }
  }

  public int findMin_(int[] nums) {
    return findMin_range(nums, 0, nums.length);
  }

  public int findMin(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] > nums[high]) {
        low = mid + 1;
      } else if (nums[low] > nums[mid]) {
        high = mid;
      } else {
        return nums[low];
      }
    }
    return 0;
  }
}
