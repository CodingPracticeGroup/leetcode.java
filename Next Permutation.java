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
------------------
public class Solution {
  public void nextPermutation(int[] nums) {
    int idx = nums.length - 2;
    while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
      idx--;
    }
    if (idx == -1) {
      reverse(nums, 0, nums.length - 1);
      return;
    }
    int idx2 = nums.length - 1;
    while (idx2 > idx && nums[idx] >= nums[idx2]) {
      idx2--;
    }
    swap(nums, idx, idx2);
    reverse(nums, idx + 1, nums.length - 1);
  }

  private void swap(int nums[], int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      swap(nums, start++, end--);
    }
  }
}
