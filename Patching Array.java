public class Solution {
  public int minPatches(int[] nums, int n) {
    int ret = 0;
    Arrays.sort(nums);
    long sum = 0; // combination sum coverage
    int idx = 0;
    while (sum < n) {
      if (idx < nums.length) {
        if (nums[idx] > sum + 1) {
          ret++;
          sum += sum + 1; // coverage extension with missing num
        } else {
          while (idx < nums.length && nums[idx] <= sum + 1) {
            sum += nums[idx++]; // coverage extension with existing num
          }
        }
      } else {
        ret++;
        sum += sum + 1; // coverage extension with missing num
      }
    }
    return ret;
  }
}
----------------
public class Solution {
  public int minPatches(int[] nums, int n) {
    int ret = 0;
    long reach = 0;
    for (int i : nums) {
      while (reach < n && reach + 1 < i) {
        ret++;
        reach += reach + 1; // patch
      }
      if (reach >= n) // check
        return ret;
      reach += i;
    }
    while (reach < n) {
      ret++;
      reach += reach + 1; // patch
    }
    return ret;
  }
}
