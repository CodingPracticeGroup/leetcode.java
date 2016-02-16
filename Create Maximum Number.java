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
--------------
public class Solution {
  private int[] mn(int[] nums, int k) {
    int ret[] = new int[k];
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    int reader = 0;
    for (int i = 0; i < k; i++) {
      maxheap.clear();
      for (int j = reader; nums.length - j >= k - i; j++) { // how many choices
        maxheap.add(nums[j]);
      }
      ret[i] = maxheap.peek();
      while (nums[reader] != maxheap.peek()) { // move to the choice
        reader++;
      }
      reader++;
    }
    return ret;
  }

  private int[] merge(int[] n1, int[] n2) {
    int ret[] = new int[n1.length + n2.length];
    int i1 = 0;
    int i2 = 0;
    while (i1 < n1.length || i2 < n2.length) {
      if (i1 < n1.length && i2 < n2.length) {
        if (n1[i1] < n2[i2]) {
          ret[i1 + i2] = n2[i2];
          i2++;
        } else if (n1[i1] > n2[i2]) {
          ret[i1 + i2] = n1[i1];
          i1++;
        } else {
          int t1 = i1;
          int t2 = i2;
          while (t1 < n1.length && t2 < n2.length && n1[t1] == n2[t2]) {
            t1++;
            t2++;
          }
          if (t1 != n1.length && t2 != n2.length) {
            if (n1[t1] < n2[t2]) {
              ret[i1 + i2] = n2[i2];
              i2++;
            } else if (n1[t1] > n2[t2]) {
              ret[i1 + i2] = n1[i1];
              i1++;
            }
          } else if (t1 == n1.length && t2 != n2.length) {
            ret[i1 + i2] = n2[i2];
            i2++;
          } else if (t1 != n1.length && t2 == n2.length) {
            ret[i1 + i2] = n1[i1];
            i1++;
          } else { // either
            ret[i1 + i2] = n1[i1];
            i1++;
          }
        }
      } else if (i1 < n1.length) {
        ret[i1 + i2] = n1[i1];
        i1++;
      } else if (i2 < n2.length) {
        ret[i1 + i2] = n2[i2];
        i2++;
      }
    }
    return ret;
  }

  private int[] compare(int[] n1, int[] n2) {
    for (int i = 0; i < n1.length && i < n2.length; i++) {
      if (n1[i] < n2[i]) {
        return n2;
      } else if (n1[i] > n2[i]) {
        return n1;
      }
    }
    return n1;
  }

  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] ret = new int[k];
    Arrays.fill(ret, Integer.MIN_VALUE);
    for (int i = 0; i <= k; i++) {
      if (i <= nums1.length && k - i <= nums2.length) {
        int[] s1 = mn(nums1, i);
        int[] s2 = mn(nums2, k - i);
        int[] s3 = merge(s1, s2);
        ret = compare(ret, s3);
      }
    }
    return ret;
  }
}
