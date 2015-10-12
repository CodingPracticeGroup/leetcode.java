import java.util.Arrays;

public class Solution {
  private boolean nextPermutation_descending(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] < nums[i]) {
        return false;
      }
    }
    return true;
  }

  public void nextPermutation(int[] nums) {
    if (nextPermutation_descending(nums)) {
      Arrays.sort(nums);
      return;
    }

    int i = nums.length - 2;
    while (i >= 0) {
      if (nums[i] >= nums[i + 1]) {
        i--;
      } else {
        break;
      }
    }

    int j = nums.length - 1;
    while (j > i) {
      if (nums[i] >= nums[j]) {
        j--;
      } else {
        break;
      }
    }

    int swap = nums[i];
    nums[i] = nums[j];
    nums[j] = swap;

    Arrays.sort(nums, i + 1, nums.length);
  }
}
