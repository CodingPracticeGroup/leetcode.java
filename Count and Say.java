public class Solution {
  private String countAndSay_once(String str) {
    int j = 0; // number
    int k = 0; // count
    StringBuilder ret = new StringBuilder();
    while (k < str.length()) {
      while (k < str.length() && str.charAt(j) == str.charAt(k)) {
        k++;
      }
      ret.append(k - j);
      ret.append(str.charAt(j));
      j = k;
    }
    return ret.toString();
  }

  public String countAndSay(int n) {
    String ret = "1";
    if (n == 1) {
      return ret;
    }
    for (int i = 1; i < n; i++) {
      ret = countAndSay_once(ret);
    }
    return ret;
  }
}
