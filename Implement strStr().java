public class Solution {
  public int strStr(String haystack, String needle) {
    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      if (haystack.startsWith(needle, i)) {
        return i;
      }
    }
    return -1;
  }

  public int strStr_(String haystack, String needle) {
    if (haystack.length() == needle.length() && haystack.equals(needle)) {
      return 0;
    }
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      if (haystack.startsWith(needle, i)) {
        return i;
      }
    }
    return -1;
  }
}
