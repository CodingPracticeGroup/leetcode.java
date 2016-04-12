public class Solution {
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char sc = s.charAt(i);
      char tc = t.charAt(i);
      if (map.containsKey(sc)) {
        if (!map.get(sc).equals(new Character(tc))) {
          return false;
        }
      } else {
        map.put(sc, tc);
      }
    }
    return map.values().stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values()
        .stream().filter(x -> x > 1).count() == 0;
  }

  private boolean mapping(String s, String t) {
    Map<Character, Character> m = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char s_ = s.charAt(i);
      char t_ = t.charAt(i);
      if (!m.containsKey(s_)) {
        m.put(s_, t_);
      }
      if (!m.get(s_).equals(t_)) {
        return false;
      }
    }
    return true;
  }

  public boolean isIsomorphic_(String s, String t) {
    return mapping(s, t) && mapping(t, s);
  }
}
-----------------
public class Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length())
      return false;
    Map<Character, Character> m = new HashMap<>(); // 正向
    Set<Character> ss = new HashSet<>(); // 反向
    for (int i = 0; i < s.length(); i++) {
      if (m.containsKey(s.charAt(i))) {
        if (t.charAt(i) != m.get(s.charAt(i)))
          return false;
      } else {
        m.put(s.charAt(i), t.charAt(i));
        if (!ss.add(t.charAt(i)))
          return false;
      }
    }
    return true;
  }
}
