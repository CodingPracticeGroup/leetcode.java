public class Solution {
  public int myAtoi(String str) {
    str = str.trim();
    int len = str.length();
    if (len == 0) {
      return 0;
    }

    boolean positive = true;
    if (str.charAt(0) == '-') {
      positive = false;
      str = str.substring(1);
      len = str.length();
    } else if (str.charAt(0) == '+') {
      str = str.substring(1);
      len = str.length();
    }

    boolean digitExists = false;
    int i = 0;
    while (i < len) {
      if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        digitExists = true;
        i++;
      } else {
        break;
      }
    }
    if (!digitExists) {
      return 0;
    }

    str = str.substring(0, i);
    if (str.length() > String.valueOf(Integer.MIN_VALUE).length()) {
      if (positive) {
        return Integer.MAX_VALUE;
      } else {
        return Integer.MIN_VALUE;
      }
    }

    long tmp = Long.valueOf(str);
    if (!positive) {
      tmp = -tmp;
    }
    if (tmp > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    } else if (tmp < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }
    return (int) tmp;
  }
}
