public class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    int min = nums.length + 1;
    int i = 0, j = 0;
    int window = 0;
    while (j < nums.length) {
      while (j < nums.length && window < s) {
        window += nums[j];
        j++;
      }
      while (window >= s) {
        window -= nums[i];
        i++;
      }
      min = Math.min(min, j - i + 1);
    }
    return min == nums.length + 1 ? 0 : min;
  }
}
-------------
public class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    int ret = Integer.MAX_VALUE;
    int last = 0;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      while (sum >= s) {
        ret = Math.min(ret, i - last + 1);
        sum -= nums[last++];
      }
    }
    if (ret == Integer.MAX_VALUE) {
      return 0;
    } else {
      return ret;
    }
  }
}
