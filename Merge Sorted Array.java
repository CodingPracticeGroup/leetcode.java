public class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int writer = m + n - 1;
    int reader1 = m - 1;
    int reader2 = n - 1;
    while (reader1 >= 0 && reader2 >= 0) {
      if (nums1[reader1] < nums2[reader2]) {
        nums1[writer] = nums2[reader2];
        writer--;
        reader2--;
      } else {
        nums1[writer] = nums1[reader1];
        writer--;
        reader1--;
      }
    }
    while (reader1 >= 0) {
      nums1[writer] = nums1[reader1];
      writer--;
      reader1--;
    }
    while (reader2 >= 0) {
      nums1[writer] = nums2[reader2];
      writer--;
      reader2--;
    }
  }
}
