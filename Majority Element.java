public class Solution {
  public int majorityElement(int[] nums) {
    int candidate = nums[0];
    int candidate_count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (candidate == nums[i]) {
        candidate_count++;
      } else {
        candidate_count--;
        if (candidate_count == 0) {
          i++;
          candidate = nums[i];
          candidate_count = 1;
        }
      }
    }
    return candidate;
  }
}
