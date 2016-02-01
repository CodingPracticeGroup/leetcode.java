public class Solution {
  public int hIndex(int[] citations) {
    if (citations.length == 0)
      return 0;
    if (citations[citations.length - 1] == 0)
      return 0;
    int low = 0;
    int high = citations.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      int h = citations.length - mid;
      if (citations[mid] >= h) {
        high = mid;
      } else if (citations[mid] < h) {
        low = mid + 1;
      }
    }
    return citations.length - low;
  }
}
---------------
public class Solution {
  public int hIndex(int[] citations) {
    if (citations.length == 0) {
      return 0;
    }
    int low = 0;
    int high = citations.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (citations.length - mid <= citations[mid]) {
        high = mid - 1; // Tie-breaking
      } else {
        low = mid + 1;
      }
    }
    return citations.length - low;
  }
}
