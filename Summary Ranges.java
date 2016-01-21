public class Solution {
  public List<String> summaryRanges_(int[] nums) {
    List<String> ret = new ArrayList<>();
    if (nums.length == 0)
      return ret;
    int last = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] + 1 != nums[i]) {
        if (last == i - 1) {
          ret.add(String.valueOf(nums[last]));
        } else {
          ret.add(String.valueOf(nums[last]) + "->" + String.valueOf(nums[i - 1]));
        }
        last = i;
      }
    }
    if (last == nums.length - 1) {
      ret.add(String.valueOf(nums[last]));
    } else {
      ret.add(String.valueOf(nums[last]) + "->" + String.valueOf(nums[nums.length - 1]));
    }
    return ret;
  }

  public List<String> summaryRanges(int[] nums) {
    List<String> ret = new ArrayList<>();
    int anchor = 0;
    while (anchor < nums.length) {
      int prober = anchor + 1;
      while (prober < nums.length && nums[prober - 1] + 1 == nums[prober]) {
        prober++;
      }
      if (anchor + 1 == prober) {
        ret.add(String.valueOf(nums[anchor]));
      } else {
        ret.add(nums[anchor] + "->" + nums[prober - 1]);
      }
      anchor = prober;
    }
    return ret;
  }
}
