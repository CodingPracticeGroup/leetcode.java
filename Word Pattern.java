public class Solution {
  public boolean wordPattern(String pattern, String str) {
    if (pattern.equals(""))
      return false;
    String[] p = pattern.split("");
    String[] s = str.split(" ");
    if (p.length != s.length)
      return false;
    Map<String, String> p2s = new HashMap<>();
    Map<String, String> s2p = new HashMap<>();
    for (int i = 0; i < p.length; i++) {
      if (p2s.containsKey(p[i]) && s2p.containsKey(s[i]) && p2s.get(p[i]).equals(s[i])
          && s2p.get(s[i]).equals(p[i])) {
        // nop
      } else if (!p2s.containsKey(p[i]) && !s2p.containsKey(s[i])) {
        p2s.put(p[i], s[i]);
        s2p.put(s[i], p[i]);
      } else {
        return false;
      }
    }
    return true;
  }
}
