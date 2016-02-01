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
--------------
public class Solution {
  public double myPow(double x, int n) {
    boolean negative = false;
    if (n < 0) {
      negative = true;
      n = -n;
    }
    long p[] = new long[32];
    double d[] = new double[32];
    p[0] = 1;
    d[0] = x;
    for (int i = 1; i < 32; i++) {
      p[i] = p[i - 1] << 1;
      d[i] = d[i - 1] * d[i - 1];
    }
    double ret = 1;
    while (n > 0) {
      for (int i = 31; i >= 0; i--) {
        if (p[i] <= n) {
          n -= p[i];
          ret *= d[i];
          break;
        }
      }
    }
    if (negative) {
      return 1 / ret;
    } else {
      return ret;
    }
  }
}
----------------
public class Solution {
  public double pow(double x, int n) {
    if (n == 0)
      return 1;
    if (n < 0) {
      n = -n;
      x = 1 / x;
    }
    return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
  }
}
------------
