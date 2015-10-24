public class Solution {
  public int hIndex(int[] citations) {
    if (citations.length == 0)
      return 0;
    int low = 0, high = citations.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      int h = citations.length - mid;
      if (citations[mid] >= h) {
        if (mid == high)
          return h;
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return citations.length - low;
  }
}
