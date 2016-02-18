public class Solution {
  public int divide(int dividend, int divisor) {
    if (divisor == 0)
      return Integer.MAX_VALUE;

    boolean negative = false;
    long dividend_long = dividend, divisor_long = divisor;
    if (dividend < 0) {
      negative = !negative;
      dividend_long = -dividend_long;
    }
    if (divisor < 0) {
      negative = !negative;
      divisor_long = -divisor_long;
    }
    if (dividend_long < divisor_long) {
      return 0;
    }

    int shift = 0;
    while (dividend_long >= divisor_long) {
      divisor_long = divisor_long << 1;
      shift++;
    }

    long ret = 0;
    while (shift >= 0) {
      if (dividend_long >= divisor_long) {
        dividend_long -= divisor_long;
        ret += 1L << shift;
      }
      shift--;
      divisor_long = divisor_long >> 1;
    }

    if (negative) {
      if (-ret < Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
      return (int) -ret;
    } else {
      if (ret > Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
      return (int) ret;
    }
  }
}
----------------
public class Solution {
  public int divide(int dividend, int divisor) {
    long d1 = Math.abs((long) dividend);
    long d2 = Math.abs((long) divisor);

    long ret = 0;
    while (d1 >= d2) {
      long r = 1;
      long d2_ = d2;
      while ((d2_ << 1) < d1) {
        d2_ = d2_ << 1;
        r += r;
      }

      ret += r;
      d1 -= d2_;
    }

    if (dividend > 0 && divisor < 0)
      ret = -ret;
    if (dividend < 0 && divisor > 0)
      ret = -ret;
    if (ret > Integer.MAX_VALUE)
      return Integer.MAX_VALUE;
    return (int) ret;
  }
}
