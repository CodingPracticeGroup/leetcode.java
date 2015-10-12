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
