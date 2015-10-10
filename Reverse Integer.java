public class Solution {
  private int reverse_positive(long x) {
    long tmp = Long.valueOf(new StringBuilder(String.valueOf(x)).reverse().toString());
    if (tmp > Integer.MAX_VALUE) {
      return 0;
    } else {
      return (int) tmp;
    }
  }

  public int reverse(int x) {
    if (x < 0) {
      return -reverse_positive(-(long) x);
    } else {
      return reverse_positive(x);
    }
  }
}
