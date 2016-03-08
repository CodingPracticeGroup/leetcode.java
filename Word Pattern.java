public class Solution {
  public boolean wordPattern_(String pattern, String str) {
    String ss[] = str.split(" ");
    if (pattern.length() != ss.length)
      return false;
    Map<Character, String> c2s = new HashMap<>();
    for (int i = 0; i < ss.length; i++) {
      char c = pattern.charAt(i);
      if (c2s.containsKey(c)) {
        if (!c2s.get(c).equals(ss[i])) {
          return false;
        }
      } else {
        c2s.put(c, ss[i]);
      }
    }
    return c2s.values().stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values()
        .stream().filter(x -> x > 1).count() == 0;
  }

  public boolean wordPattern(String pattern, String str) {
    String[] strs = str.split(" ");
    if (pattern.length() != strs.length) {
      return false;
    }
    Map<Character, String> m = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      if (!m.containsKey(c)) {
        m.put(c, strs[i]);
      }
      if (!m.get(c).equals(strs[i])) {
        return false;
      }
    }
    return m.values().stream().distinct().count() == m.size();
  }
}
----------------
public class Solution {
  public boolean wordPattern(String pattern, String str) {
    String strs[] = str.split(" ");
    if (strs.length != pattern.length())
      return false;
    Map<Character, String> m = new HashMap<>();
    Set<String> check = new HashSet<>();
    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      if (m.containsKey(c)) {
        if (!strs[i].equals(m.get(c)))
          return false;
      } else {
        if (check.contains(strs[i]))
          return false;
        m.put(c, strs[i]);
        check.add(strs[i]);
      }
    }
    return true; // default true process, add false check in the last step during programing
  }
}
