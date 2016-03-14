public class Solution {
  public int myAtoi(String str) {
    str = str.trim();
    if (str.length() == 0) {
      return 0;
    }

    boolean negative = false;
    if (str.charAt(0) == '-') {
      str = str.substring(1);
      negative = true;
    } else if (str.charAt(0) == '+') {
      str = str.substring(1);
    }
    for (int i = 0; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i))) {
        str = str.substring(0, i);
        break;
      }
    }
    if (str.length() == 0) {
      return 0;
    }

    if (str.length() > String.valueOf(Integer.MAX_VALUE).length()) {
      if (negative) {
        return Integer.MIN_VALUE;
      } else {
        return Integer.MAX_VALUE;
      }
    }

    long l = Long.parseLong(str);
    if (negative) {
      l = -l;
    }

    if (l < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    } else if (l > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }

    return (int) l;
  }
}
-------------------
public class Solution {
  public int myAtoi(String str) {
    str = str.trim();
    if (str.isEmpty())
      return 0;

    boolean negative = false;
    if (str.charAt(0) == '-') {
      negative = true;
      str = str.substring(1);
    } else if (str.charAt(0) == '+') {
      str = str.substring(1);
    }

    long d = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        d *= 10;
        d += str.charAt(i) - '0';
        if (d > 1L + Integer.MAX_VALUE) {
          break;
        }
      } else {
        break;
      }
    }

    if (!negative && d > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    if (negative && -d < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    return negative ? -(int) d : (int) d;
  }
}
