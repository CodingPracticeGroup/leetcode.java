public class Solution {
  private int reverse_positive(long x) {
    long tmp = Long.valueOf(new StringBuilder(String.valueOf(x)).reverse().toString());
    if (tmp > Integer.MAX_VALUE) {
      return 0;
    } else {
      return (int) tmp;
    }
  }

  public int reverse_(int x) {
    if (x < 0) {
      return -reverse_positive(-(long) x);
    } else {
      return reverse_positive(x);
    }
  }

  private long digit(long x, int offset) {
    for (int i = 0; i < offset; i++) {
      x /= 10;
    }
    return x % 10;
  }

  private int len(long x) {
    int ret = 1;
    while (x >= 10) {
      x /= 10;
      ret++;
    }
    return ret;
  }

  public int reverse(int x) {
    long y = x;
    boolean negative = false;
    if (y < 0) {
      negative = true;
      y = -y;
    }
    long z = 0;
    int len = len(y);
    for (int i = 0; i < len; i++) {
      long d = digit(y, i);
      z = z * 10 + d;
    }
    if (negative) {
      z = -z;
    }
    if (z < Integer.MIN_VALUE || z > Integer.MAX_VALUE) {
      return 0;
    } else {
      return (int) z;
    }
  }
}
