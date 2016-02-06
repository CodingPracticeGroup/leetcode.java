public class Solution {
  private int maxProduct_without0(int[] nums, int start, int end) {
    if (start >= end) {
      return 0;
    }
    if (start + 1 == end) {
      return nums[start];
    }
    int negativeCount = 0;
    int ret = 1;
    for (int i = start; i < end; i++) {
      ret *= nums[i];
      if (nums[i] < 0) {
        negativeCount++;
      }
    }
    if (negativeCount % 2 == 0) {
      return ret;
    } else {
      int i;
      int left = 1;
      for (i = start; i < end && nums[i] > 0; i++) {
        left *= nums[i];
      }
      if (i < end)
        left *= nums[i];
      int right = 1;
      for (i = end - 1; i >= start && nums[i] > 0; i--) {
        right *= nums[i];
      }
      if (i >= start)
        right *= nums[i];
      return Math.max(ret / left, ret / right);
    }
  }

  public int maxProduct(int[] nums) {
    int last = 0;
    while (last < nums.length && nums[last] == 0) {
      last++;
    }
    int max = Integer.MIN_VALUE;
    boolean zero = false;
    for (int i = last; i < nums.length; i++) {
      if (nums[i] == 0) {
        int seg_max = maxProduct_without0(nums, last, i);
        max = Math.max(max, seg_max);
        last = i + 1;
        zero = true;
      }
    }
    max = Math.max(max, maxProduct_without0(nums, last, nums.length));
    if (zero) {
      max = Math.max(max, 0);
    }
    return max;
  }
}
-----------
public class Solution {
  private int mp(int[] nums, int i, int j) {
    if (i >= j) {
      return Integer.MIN_VALUE;
    }
    if (i + 1 == j) {
      return nums[i];
    }

    int p = 1;
    int first = -1;
    for (int k = i; k < j; k++) {
      p *= nums[k];
      if (nums[k] < 0) {
        first = k;
        break;
      }
    }
    if (first == -1) {
      return p;
    }

    int q = 1;
    int last = -1;
    for (int k = j - 1; k >= 0; k--) {
      q *= nums[k];
      if (nums[k] < 0) {
        last = k;
        break;
      }
    }
    if (first == last) {
      return Math.max(p / nums[first], q / nums[last]);
    }

    int r = 1;
    for (int k = first + 1; k < last; k++) {
      r *= nums[k];
    }
    if (r > 0) {
      return p * q * r;
    } else {
      return Math.max(p * r, q * r);
    }
  }

  public int maxProduct(int[] nums) {
    int ret = Integer.MIN_VALUE;
    int i = 0;
    int p = 1;
    for (int j = 0; j < nums.length; j++) {
      p *= nums[j];
      if (nums[j] == 0) {
        ret = Math.max(ret, mp(nums, i, j));
        ret = Math.max(ret, 0);
        i = j + 1;
      }
    }
    ret = Math.max(ret, mp(nums, i, nums.length));
    if (ret == Integer.MIN_VALUE) {
      return p;
    }
    return ret;
  }
}
---------------
public class Solution {
  public int maxProduct(int[] A) {
    if (A.length == 0) {
      return 0;
    }

    int maxherepre = A[0];
    int minherepre = A[0];
    int maxsofar = A[0];
    int maxhere, minhere;

    for (int i = 1; i < A.length; i++) {
      maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
      minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);

      maxsofar = Math.max(maxhere, maxsofar);

      maxherepre = maxhere;
      minherepre = minhere;
    }
    return maxsofar;
  }
}
