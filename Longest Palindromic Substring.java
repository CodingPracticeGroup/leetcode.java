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
