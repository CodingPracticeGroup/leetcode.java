public class Solution {
  public int majorityElement(int[] nums) {
    int ret = 0;
    int count = 0;
    for (int i : nums) {
      if (count == 0) {
        ret = i;
        count = 1;
      } else {
        if (i == ret) {
          count++;
        } else {
          count--;
        }
      }
    }
    return ret;
  }
}
