public class Solution {
  public String longestPalindrome(String s) {
    int len = s.length();
    int maxi = 0, maxj = 0;
    for (int i = 0; i < len; i++) {
      for (int j = 1; i - j >= 0 && i + j < len && s.charAt(i - j) == s.charAt(i + j); j++) {
        if ((maxj - maxi) < (i + j) - (i - j)) {
          maxi = i - j;
          maxj = i + j;
        }
      }
    }
    for (int i = 0; i < len - 1; i++) {
      for (int j = 0; i - j >= 0 && i + 1 + j < len && s.charAt(i - j) == s.charAt(i + 1 + j); j++) {
        if ((maxj - maxi) < (i + 1 + j) - (i - j)) {
          maxi = i - j;
          maxj = i + 1 + j;
        }
      }
    }
    return s.substring(maxi, maxj + 1);
  }
}
------------
public class Solution {
  private int[] check(String s, int i, int j) {
    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
      i--;
      j++;
    }
    return new int[] {i + 1, j - 1};
  }

  public String longestPalindrome(String s) {
    int c1 = 0;
    int c2 = 0;
    for (int i = 0; i < s.length(); i++) {
      int l[] = check(s, i, i);
      if (c2 - c1 < l[1] - l[0]) {
        c1 = l[0];
        c2 = l[1];
      }
    }
    for (int i = 0; i + 1 < s.length(); i++) {
      int l[] = check(s, i, i + 1);
      if (c2 - c1 < l[1] - l[0]) {
        c1 = l[0];
        c2 = l[1];
      }
    }
    return s.substring(c1, c2 + 1);
  }
}
