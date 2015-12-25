public class Solution {
  int[] maxInArray(int[] nums, int len) {
    int[] ret = new int[len]; // stack
    int idx = 0; // stack pointer
    for (int i = 0; i < nums.length; i++) {
      while (idx > 0 && ret[idx - 1] < nums[i] && len - idx < nums.length - i) {
        idx--;
      }
      if (idx < len) {
        ret[idx++] = nums[i];
      }
    }
    return ret;
  }

  int[] mergeArray(int[] nums1, int nums2[]) {
    int[] ret = new int[nums1.length + nums2.length];
    int i = 0;
    int j = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        ret[i + j] = nums2[j];
        j++;
      } else if (nums1[i] > nums2[j]) {
        ret[i + j] = nums1[i];
        i++;
      } else {
        int tmp_i = i;
        int tmp_j = j;
        while (tmp_i < nums1.length && tmp_j < nums2.length && nums1[tmp_i] == nums2[tmp_j]) {
          tmp_i++;
          tmp_j++;
        }
        if (tmp_i == nums1.length && tmp_j == nums2.length) {
          // they are same; pick either
          ret[i + j] = nums2[j];
          j++;
        } else if (tmp_i == nums1.length || tmp_j == nums2.length) {
          // pick longer
          if (tmp_i == nums1.length) {
            ret[i + j] = nums2[j];
            j++;
          } else {
            ret[i + j] = nums1[i];
            i++;
          }
        } else {
          if (nums1[tmp_i] < nums2[tmp_j]) {
            ret[i + j] = nums2[j];
            j++;
          } else if (nums1[tmp_i] > nums2[tmp_j]) {
            ret[i + j] = nums1[i];
            i++;
          }
        }
      }
    }
    while (i < nums1.length) {
      ret[i + j] = nums1[i];
      i++;
    }
    while (j < nums2.length) {
      ret[i + j] = nums2[j];
      j++;
    }
    return ret;
  }

  int compareArray(int[] nums1, int[] nums2) {
    for (int i = 0; i < nums1.length; i++) {
      if (nums1[i] != nums2[i]) {
        return nums1[i] - nums2[i];
      }
    }
    return 0;
  }

  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] ret = new int[k];
    for (int lenIn1 = 0; lenIn1 <= Math.min(k, nums1.length); lenIn1++) {
      int lenIn2 = k - lenIn1;
      if (lenIn2 <= nums2.length) {
        int[] sub1 = maxInArray(nums1, lenIn1);
        int[] sub2 = maxInArray(nums2, lenIn2);
        int[] merge = mergeArray(sub1, sub2);
        if (compareArray(merge, ret) > 0) {
          ret = merge;
        }
      }
    }
    return ret;
  }
}
