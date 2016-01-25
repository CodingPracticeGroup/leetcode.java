public class Solution {
  public int maxSubArray(int[] nums) {
    int max = nums[0];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      max = Math.max(max, sum);
      if (sum < 0) { // if negative contribution
        sum = 0; // start from scratch
      }
    }
    return max;
  }

  public int maxSubArray_(int[] nums) {
    if (Arrays.stream(nums).filter(x -> x > 0).count() == 0) {
      return Arrays.stream(nums).max().getAsInt();
    }
    int ret = 0;
    int sum = 0;
    for (int i : nums) {
      sum += i; // (~, i]
      if (sum < 0) {
        sum = 0; // remove negative impact
      } else {
        ret = Math.max(ret, sum);
      }
    }
    return ret;
  }
}
