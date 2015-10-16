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
