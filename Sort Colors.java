public class Solution {
  public void sortColors_(int[] nums) {
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

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public void sortColors(int[] nums) {
    int writer0 = 0;
    while (writer0 < nums.length && nums[writer0] == 0) {
      writer0++;
    }
    int writer2 = nums.length - 1;
    while (writer2 >= 0 && nums[writer2] == 2) {
      writer2--;
    }
    for (int reader = writer0; reader <= writer2; reader++) {
      if (nums[reader] == 2) {
        swap(nums, reader, writer2--);
        while (writer2 >= 0 && nums[writer2] == 2) {
          writer2--;
        }
      }
      if (nums[reader] == 0) {
        swap(nums, reader, writer0++);
        while (writer0 < reader && nums[writer0] == 0) {
          writer0++;
        }
      }
    }
  }
}
