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
-------------------
public class Solution {
  private boolean ia(String n, long i, long j) {
    if (n.equals(""))
      return true;
    if (i + j != 0 && n.charAt(0) == '0')
      return false; // prune '0'
    String k = String.valueOf(i + j);
    if (!n.startsWith(k))
      return false;
    return ia(n.substring(k.length()), j, i + j);
  }

  public boolean isAdditiveNumber(String num) {
    for (int len1 = 1; len1 < num.length(); len1++) {
      if (!(num.charAt(0) == '0' && len1 - 0 > 1)) { // prune '0'
        long i = Long.parseLong(num.substring(0, len1));
        for (int len2 = len1 + 1; len2 < num.length(); len2++) {
          if (!(num.charAt(len1) == '0' && len2 - len1 > 1)) { // prune '0'
            long j = Long.parseLong(num.substring(len1, len2));
            if (ia(num.substring(len2), i, j))
              return true;
          }
        }
      }
    }
    return false;
  }
}
