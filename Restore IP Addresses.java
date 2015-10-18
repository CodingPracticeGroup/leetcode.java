public class Solution {
  private boolean restoreIpAddresses_valid(String s, int start, int end) {
    if (end - start == 1) {
      return true;
    } else if (end - start == 2) {
      int t = Integer.valueOf(s.substring(start, end));
      if (10 <= t && t <= 99) {
        return true;
      }
    } else if (end - start == 3) {
      int t = Integer.valueOf(s.substring(start, end));
      if (100 <= t && t <= 255) {
        return true;
      }
    }
    return false;
  }

  public List<String> restoreIpAddresses(String s) {
    int len = s.length();
    List<String> ret = new ArrayList<>();
    for (int i = 1; i <= 3 && i <= len; i++) {
      if (restoreIpAddresses_valid(s, 0, i)) {
        String p1 = s.substring(0, i);
        for (int j = i + 1; j <= i + 3 && j <= len; j++) {
          if (restoreIpAddresses_valid(s, i, j)) {
            String p2 = s.substring(i, j);
            for (int k = j + 1; k <= k + 3 && k <= len; k++) {
              if (restoreIpAddresses_valid(s, j, k) && restoreIpAddresses_valid(s, k, s.length())) {
                String p3 = s.substring(j, k);
                String p4 = s.substring(k, s.length());
                ret.add(p1 + '.' + p2 + '.' + p3 + '.' + p4);
              }
            }
          }
        }
      }
    }
    return ret;
  }
}
