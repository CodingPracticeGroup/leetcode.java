public class Solution {
  private boolean isAdditiveNumber(String num, int start, long n1, long n2) {
    if (start >= num.length())
      return false;
    if (num.charAt(start) == '0')
      return false;
    long n3 = n1 + n2;
    String prefix = String.valueOf(n3);
    for (int i = 0; i < prefix.length(); i++) {
      if (start + i < num.length()) {
        if (prefix.charAt(i) != num.charAt(start + i)) {
          return false;
        }
      } else {
        return false;
      }
    }
    if (start + prefix.length() == num.length())
      return true;
    else
      return isAdditiveNumber(num, start + prefix.length(), n2, n3);
  }

  public boolean isAdditiveNumber(String num) {
    int len = num.length() / 2;
    for (int i = 1; i <= len; i++) {
      long n1 = Long.parseLong(num.substring(0, i));
      for (int j = 1; j <= len; j++) {
        if (num.charAt(i) != '0' || (num.charAt(i) == '0' && j == 1)) {
          long n2 = Long.parseLong(num.substring(i, i + j));
          if (isAdditiveNumber(num, i + j, n1, n2))
            return true;
        }
      }
    }
    return false;
  }
}
--------------
public class Solution {
  private boolean is(String num, int start, long first, long second) {
    if (start >= num.length()) {
      return true;
    }
    String sum = String.valueOf(first + second);
    if (num.charAt(start) == '0' && first + second != 0) {
      return false;
    }
    if (num.startsWith(sum, start)) {
      return is(num, start + sum.length(), second, first + second);
    }
    return false;
  }

  public boolean isAdditiveNumber(String num) {
    for (int i = 1; i < num.length(); i++) {
      long first = Long.parseLong(num.substring(0, i));
      if (num.charAt(0) == '0' && first != 0) {
        continue;
      }
      for (int j = i + 1; j < num.length(); j++) {
        long second = Long.parseLong(num.substring(i, j));
        if (num.charAt(i) == '0' && second != 0) {
          continue;
        }
        if (is(num, j, first, second)) {
          return true;
        }
      }
    }
    return false;
  }
}
