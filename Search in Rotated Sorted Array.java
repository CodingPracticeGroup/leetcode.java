public class Solution {
  private int search_range(int[] nums, int target, int low, int high) {
    if (low <= high) {
      if (nums[low] <= nums[high]) {
        return search_wrapper(nums, low, high + 1, target);
      }
      int mid = (low + high) / 2;
      if (target == nums[mid]) {
        return mid;
      } else {
        if (nums[low] > nums[mid]) {
          if (nums[mid] <= target && target <= nums[high]) {
            return search_wrapper(nums, mid + 1, high + 1, target);
          } else {
            return search_range(nums, target, low, mid - 1);
          }
        } else if (nums[mid] > nums[high]) {
          if (nums[low] <= target && target <= nums[mid]) {
            return search_wrapper(nums, low, mid, target);
          } else {
            return search_range(nums, target, mid + 1, high);
          }
        }
      }
    }
    return -1;
  }

  private int search_wrapper(int[] nums, int start, int end, int target) {
    int ret = Arrays.binarySearch(nums, start, end, target);
    if (ret < 0)
      return -1;
    else
      return ret;
  }

  public int search(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    return search_range(nums, target, low, high);
  }
}
