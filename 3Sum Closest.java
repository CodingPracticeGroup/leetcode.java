public class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int ret = nums[0] + nums[1] + nums[2];
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      int j = i + 1, k = nums.length - 1;
      while (j < k) {
        if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(ret - target)) {
          ret = nums[i] + nums[j] + nums[k];
        }
        if (nums[i] + nums[j] + nums[k] < target) {
          j++;
        } else if (target < nums[i] + nums[j] + nums[k]) {
          k--;
        } else {
          return ret;
        }
      }
    }
    return ret;
  }
}
----------------
public class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int ret = nums[0] + nums[1] + nums[2];
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (Math.abs(target - sum) < Math.abs(target - ret)) {
          ret = sum;
        }
        if (sum < target) {
          j++;
        } else if (sum > target) {
          k--;
        } else {
          return ret;
        }
      }
    }
    return ret;
  }
}
