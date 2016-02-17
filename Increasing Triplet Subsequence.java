public class Solution {
  public boolean increasingTriplet(int[] nums) {
    int i = -1;
    int j = -1;
    int k = -1;
    for (j = 1; j < nums.length; j++) { // find two
      if (nums[j - 1] < nums[j]) {
        i = j - 1;
        break;
      }
    }
    Integer I = null;
    for (k = j + 1; k < nums.length; k++) { // find third
      if (nums[k] > nums[j]) {
        return true;
      }
      if (nums[i] < nums[k] && nums[k] < nums[j]) { // update second
        j = k;
      } else if (nums[k] < nums[i]) { // find candidate first
        if (I == null) {
          I = k;
        } else {
          if (nums[k] < nums[I]) {
            I = k;
          } else if (nums[I] < nums[k]) { // update first and second
            i = I;
            j = k;
            I = null;
          }
        }
      }
    }
    return false;
  }
}
-----------
public class Solution {
  public boolean increasingTriplet(int[] nums) {
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;
    for (int i : nums) {
      if (i <= first) { // greedy
        first = i;
      } else if (i <= second) { // greedy
        second = i;
      } else {
        return true;
      }
    }
    return false;
  }
}
