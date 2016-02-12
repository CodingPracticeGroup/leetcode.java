public class Solution {
  public int jump(int[] nums) {
    int count = 0;
    int idx = 0; // where you start
    int far = nums[0]; // the most far idx you can reach
    while (idx < nums.length - 1) {
      int next_far = 0;
      for (int i = idx; i < nums.length && i <= far; i++) { // greedy
        next_far = Math.max(next_far, i + nums[i]);
      }
      idx = far;
      far = next_far;
      count++;
    }
    return count;
  }
}
--------------
public class Solution {
  public int jump(int[] nums) {
    int ret = 0;
    int whereIAm = 0;
    for (int canReach = whereIAm + nums[whereIAm]; whereIAm < nums.length - 1; ret++) {
      int nextCanReach = canReach;
      for (int i = whereIAm + 1; i <= canReach && i < nums.length; i++) {
        nextCanReach = Math.max(nextCanReach, nums[i] + i);
      }
      whereIAm = canReach;
      canReach = nextCanReach;
    }
    return ret;
  }
}
