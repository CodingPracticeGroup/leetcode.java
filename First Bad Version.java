public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    int low = 1;
    int high = n;
    while (low < high) {
      // (low+high)/2 may exceed Integer.MAX_VALUE
      int mid = low + (high - low) / 2;
      if (isBadVersion(mid)) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return high;
  }
}
