public class Solution {
  public void sortColors(int[] nums) {
    int i = 0, j = 0; // insert pos
    int k = 0; // scan head
    while (k < nums.length) {
      if (nums[k] == 0) {
        int t = nums[k];
        nums[k] = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
        i++;
        j++;
      } else if (nums[k] == 1) {
        int t = nums[k];
        nums[k] = nums[j];
        nums[j] = t;
        j++;
      }
      k++;
    }
  }
}
