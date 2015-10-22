public class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> ret = new ArrayList<>();
    if (nums.length == 0)
      return ret;
    int i = 0, j = 1;
    while (j < nums.length) {
      if (nums[j - 1] + 1 != nums[j]) {
        StringBuilder sb = new StringBuilder();
        sb.append(nums[i]);
        if (i + 1 != j) {
          sb.append("->");
          sb.append(nums[j - 1]);
        }
        ret.add(sb.toString());
        i = j;
      }
      j++;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(nums[i]);
    if (i + 1 != j) {
      sb.append("->");
      sb.append(nums[j - 1]);
    }
    ret.add(sb.toString());
    return ret;
  }
}
