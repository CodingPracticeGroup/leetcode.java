public class Solution {
  private boolean search_(int[] nums, int target, int low, int high) {
    if (low > high) {
      return false;
    }
    if (low == high) {
      return nums[low] == target;
    }
    int mid = (low + high) / 2;
    if (nums[low] < nums[high]) {
      return Arrays.binarySearch(nums, low, high + 1, target) >= 0;
    } else {
      if (nums[low] < nums[mid]) {
        if (nums[low] <= target && target <= nums[mid]) {
          return Arrays.binarySearch(nums, low, mid + 1, target) >= 0;
        } else {
          return search_(nums, target, mid + 1, high);
        }
      } else if (nums[mid] < nums[high]) {
        if (nums[mid] <= target && target <= nums[high]) {
          return Arrays.binarySearch(nums, mid, high + 1, target) >= 0;
        } else {
          return search_(nums, target, low, mid);
        }
      } else {
        return search_(nums, target, low, mid) || search_(nums, target, mid + 1, high);
      }
    }
  }

  public boolean search(int[] nums, int target) {
    return search_(nums, target, 0, nums.length - 1);
  }
}
----------------
public class Solution {
  private boolean s(int[] nums, int target, int low, int high) {
    if (high < low) {
      return false;
    }
    int mid = low + (high - low) / 2;
    if (nums[low] == nums[high]) {
      if (nums[mid] == target) {
        return true;
      } else {
        return s(nums, target, low, mid - 1) || s(nums, target, mid + 1, high);
      }
    } else {
      if (nums[mid] == target) {
        return true;
      } else if (nums[low] <= target && target <= nums[mid]) { // benefit from sorted subarray
        return Arrays.binarySearch(nums, low, mid + 1, target) >= 0;
      } else if (nums[mid] <= target && target <= nums[high]) { // benefit from sorted subarray
        return Arrays.binarySearch(nums, mid, high + 1, target) >= 0;
      } else {
        return s(nums, target, low, mid - 1) || s(nums, target, mid + 1, high);
      }
    }
  }

  public boolean search(int[] nums, int target) {
    return s(nums, target, 0, nums.length - 1);
  }
}
