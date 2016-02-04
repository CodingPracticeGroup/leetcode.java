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
----------------
public class Solution {
  private boolean valid(String s) {
    if (s.length() > 1 && s.charAt(0) == '0') {
      return false;
    }
    if (s.length() > 3 || s.length() <= 0) {
      return false;
    }
    int i = Integer.parseInt(s);
    if (i < 0 || i > 255) {
      return false;
    }
    return true;
  }

  public List<String> restoreIpAddresses(String s) {
    List<String> ret = new ArrayList<>();
    for (int i = 1; i <= s.length(); i++) {
      String s1 = s.substring(0, i);
      if (!valid(s1)) {
        continue;
      }
      for (int j = i + 1; j <= s.length(); j++) {
        String s2 = s.substring(i, j);
        if (!valid(s2)) {
          continue;
        }
        for (int k = j + 1; k <= s.length(); k++) {
          String s3 = s.substring(j, k);
          String s4 = s.substring(k);
          if (!valid(s3) || !valid(s4)) {
            continue;
          }
          ret.add(s1 + "." + s2 + "." + s3 + "." + s4);
        }
      }
    }
    return ret;
  }
}
