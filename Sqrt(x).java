public class Solution {
  public int mySqrt(int x) {
    if (x == 0)
      return 0;
    if (x == 1)
      return 1;
    long low = 1;
    long high = x;
    long mid = (low + high) / 2;
    while (low < mid && mid < high) {
      if (mid * mid > x) {
        high = mid;
      } else if (mid * mid < x) {
        low = mid;
      } else {
        return (int) mid;
      }
      mid = (low + high) / 2;
    }
    return (int) mid;
  }
}
-----------
public class Solution {
  public int mySqrt(int x) {
    long low = 1;
    long high = x;
    while (low <= high) {
      long mid = low + (high - low) / 2;
      if (mid * mid < x) {
        low = mid + 1;
      } else if (x < mid * mid) {
        high = mid - 1;
      } else {
        return (int) mid;
      }
    }
    return (int) high;
  }
}
