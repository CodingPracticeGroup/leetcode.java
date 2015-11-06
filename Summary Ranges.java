public class Solution {
  public List<String> summaryRanges(int[] nums) {
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
}
