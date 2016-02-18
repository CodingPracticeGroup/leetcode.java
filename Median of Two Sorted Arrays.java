import java.util.ArrayList;
import java.util.List;

public class Solution {
  private double findMedianSortedArrays_median_sorted(int[] nums1, int start1, int end1) {
    int len = end1 - start1;
    if (len % 2 == 0) {
      return (nums1[start1 + len / 2 - 1] + nums1[start1 + len / 2]) / 2.0;
    } else {
      return nums1[start1 + len / 2];
    }
  }

  private double findMedianSortedArrays_median(int[] nums1, int start1, int end1, int[] nums2,
      int start2, int end2) {
    List<Integer> temp = new ArrayList<>();
    for (int i = start1; i < end1; i++) {
      temp.add(nums1[i]);
    }
    for (int i = start2; i < end2; i++) {
      temp.add(nums2[i]);
    }
    temp.sort((x, y) -> x - y);
    int len = temp.size();
    if (len % 2 == 0) {
      return (temp.get(len / 2 - 1) + temp.get(len / 2)) / 2.0;
    } else {
      return temp.get(len / 2);
    }
  }

  private double findMedianSortedArrays_recursion(int[] nums1, int start1, int end1, int[] nums2,
      int start2, int end2) {
    if (end1 - start1 == 1) {
      if (end2 - start2 == 1) {
        return findMedianSortedArrays_median(nums1, start1, end1, nums2, start2, end2);
      } else if ((end2 - start2) % 2 == 0) {
        return findMedianSortedArrays_median(nums1, start1, end1, nums2, (start2 + end2) / 2 - 1,
            (start2 + end2) / 2 + 1);
      } else {
        return findMedianSortedArrays_median(nums1, start1, end1, nums2, (start2 + end2) / 2 - 1,
            (start2 + end2) / 2 + 2);
      }
    } else if (end1 - start1 == 2) {
      if (end2 - start2 == 2) {
        return findMedianSortedArrays_median(nums1, start1, end1, nums2, start2, end2);
      } else if ((end2 - start2) % 2 == 0) {
        return findMedianSortedArrays_median(nums1, start1, end1, nums2, (start2 + end2) / 2 - 2,
            (start2 + end2) / 2 + 2);
      } else {
        return findMedianSortedArrays_median(nums1, start1, end1, nums2, (start2 + end2) / 2 - 1,
            (start2 + end2) / 2 + 2);
      }
    }
    int count = (end1 - start1 - 1) / 2;
    if (nums1[start1 + (end1 - start1 - 1) / 2] <= nums2[start2 + (end2 - start2 - 1) / 2]) {
      return findMedianSortedArrays_recursion(nums1, start1 + count, end1, nums2, start2, end2
          - count);
    } else {
      return findMedianSortedArrays_recursion(nums1, start1, end1 - count, nums2, start2 + count,
          end2);
    }
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length == 0 && nums2.length > 0) {
      return findMedianSortedArrays_median_sorted(nums2, 0, nums2.length);
    } else if (nums1.length > 0 && nums2.length == 0) {
      return findMedianSortedArrays_median_sorted(nums1, 0, nums1.length);
    } else if (nums1.length == 0 && nums2.length == 0) {
      return 0;
    }
    if (nums1.length < nums2.length) {
      return findMedianSortedArrays_recursion(nums1, 0, nums1.length, nums2, 0, nums2.length);
    } else {
      return findMedianSortedArrays_recursion(nums2, 0, nums2.length, nums1, 0, nums1.length);
    }
  }
}
---------------
public class Solution {
  private int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) { // starts with 1
    if (start1 >= nums1.length)
      return nums2[start2 + k - 1];
    if (start2 >= nums2.length)
      return nums1[start1 + k - 1];
    if (k == 1)
      return Math.min(nums1[start1], nums2[start2]);

    int amid = Integer.MAX_VALUE;
    int bmid = Integer.MAX_VALUE;
    if (start1 + k / 2 - 1 < nums1.length)
      amid = nums1[start1 + k / 2 - 1];
    if (start2 + k / 2 - 1 < nums2.length)
      bmid = nums2[start2 + k / 2 - 1];

    if (amid < bmid) { // remove a head
      return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
    } else { // remove b head
      return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
    }
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int i = findKth(nums1, 0, nums2, 0, (nums1.length + nums2.length + 1) / 2);
    if ((nums1.length + nums2.length) % 2 == 0) {
      int j = findKth(nums1, 0, nums2, 0, (nums1.length + nums2.length + 2) / 2);
      return (i * 1.0 + j) / 2;
    } else {
      return i;
    }
  }
}
