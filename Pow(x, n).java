public class Solution {
  private double myPow_positive(double x, int n) {
    if (n == 1) {
      return x;
    } else if (n == 0) {
      return 1;
    }
    int n2 = n / 2;
    double r = myPow_positive(x, n2);
    if (n2 + n2 + 1 == n) {
      return r * r * x;
    } else { // n2+n2=n
      return r * r;
    }
  }

  public double myPow(double x, int n) {
    double ret = myPow_positive(x, Math.abs(n));
    if (n < 0) {
      return 1 / ret;
    }
    return ret;
  }
}
