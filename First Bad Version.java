/*
 * The isBadVersion API is defined in the parent class VersionControl. boolean isBadVersion(int
 * version);
 */

public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    int low = 1;
    int high = n;
    while (low < high) {
      int mid = low + (high - low) / 2; // tend to 0, apart from high
      boolean b = isBadVersion(mid);
      if (b) { // bad<=mid
        high = mid; // bad in {low , high]
      } else { // mid<bad
        low = mid + 1;
      }
    }
    return high;
  }
}
