public class Solution {
    private int findMin_range(int[] nums, int start, int end) {
        if (start+1==end) return nums[start];
        if (start+2==end) return Math.min(nums[start], nums[start+1]);
        int mid = (start+end)/2;
        if(nums[start]<nums[mid] && nums[mid]<nums[end-1]) {
            return nums[start];
        } else if (nums[start]<nums[mid]) {
            return Math.min(nums[start], findMin_range(nums, mid+1, end));
        } else if (nums[mid]<nums[end-1]) {
            return Math.min(nums[mid], findMin_range(nums, start, mid));
        } else {
            return Math.min(findMin_range(nums, start, mid), findMin_range(nums, mid, end));
        }
    }
    public int findMin(int[] nums) {
        return findMin_range(nums, 0, nums.length);
    }
}
-------------------
public class Solution {
  private int fm(int[] nums, int low, int high) {
    if (low == high) {
      return nums[low];
    } else if (low > high) {
      return Integer.MAX_VALUE;
    }
    int mid = low + (high - low) / 2;
    if (nums[low] > nums[mid]) { // pivot here
      return Math.min(nums[mid], fm(nums, low, mid - 1));
    } else if (nums[mid] > nums[high]) { // pivot here
      return Math.min(nums[high], fm(nums, mid, high - 1));
    } else { // pivot unknown
      int ret = nums[mid];
      ret = Math.min(ret, fm(nums, low, mid - 1));
      ret = Math.min(ret, fm(nums, mid + 1, high));
      return ret;
    }
  }

  public int findMin(int[] nums) {
    return fm(nums, 0, nums.length - 1);
  }
}
