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
-----------
public class Solution {
  private int s(int[] nums, int target, int low, int high) {
    if (low > high) {
      return -1;
    }
    if (nums[low] <= nums[high]) { // no rotate
      int r = Arrays.binarySearch(nums, low, high + 1, target);
      return r < 0 ? -1 : r;
    }

    int mid = low + (high - low) / 2;
    if (nums[mid] == target) { // hit
      return mid;
    } else if (nums[low] <= target && target < nums[mid]) { // find range
      int r = Arrays.binarySearch(nums, low, mid, target);
      return r < 0 ? -1 : r;
    } else if (nums[mid] < target && target <= nums[high]) { // find range
      int r = Arrays.binarySearch(nums, mid + 1, high + 1, target);
      return r < 0 ? -1 : r;
    }

    int ret = s(nums, target, low, mid - 1); // try left
    if (ret >= 0) {
      return ret;
    }
    ret = s(nums, target, mid + 1, high); // try right
    return ret;
  }

  public int search(int[] nums, int target) {
    return s(nums, target, 0, nums.length - 1);
  }
}
