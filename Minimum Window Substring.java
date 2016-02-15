public class Solution {
  private void minWindow_map_put(Map<Character, Long> map, char c) {
    if (map.containsKey(c)) {
      map.put(c, map.get(c) + 1);
    } else {
      map.put(c, 1L);
    }
  }

  private void minWindow_map_remove(Map<Character, Long> map, char c) {
    map.put(c, map.get(c) - 1);
    if (map.get(c) == 0) {
      map.remove(c);
    }
  }

  private int minWindow_j(String s, Map<Character, Long> T, Map<Character, Long> window) {
    int j = 0;
    Map<Character, Long> T_ = new HashMap<>(T);
    for (j = 0; j < s.length(); j++) {
      char c = s.charAt(j);
      if (T.containsKey(c)) {
        minWindow_map_put(window, c);
      }
      if (T_.containsKey(c)) {
        minWindow_map_remove(T_, c);
        if (T_.isEmpty()) {
          break;
        }
      }
    }
    if (T_.isEmpty()) {
      return j;
    } else {
      return -1;
    }
  }

  private int minWindow_i(String s, Map<Character, Long> T, int i, Map<Character, Long> window) {
    while (i < s.length()) {
      char c = s.charAt(i);
      if (T.containsKey(c)) {
        if (window.get(c) > T.get(c)) {
          minWindow_map_remove(window, c);
          i++;
        } else {
          return i;
        }
      } else {
        i++;
      }
    }
    return i;
  }

  public String minWindow(String s, String t) {
    Map<Character, Long> T =
        t.chars().mapToObj(x -> new Character((char) x))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    int i = 0, j = 0;
    int minLen = s.length();
    String ret = "";
    Map<Character, Long> window = new HashMap<>();
    // [i, j]
    j = minWindow_j(s, T, window);
    if (j < 0) {
      return ret;
    }
    i = minWindow_i(s, T, 0, window);
    minLen = j - i + 1;
    ret = s.substring(i, j + 1);
    //
    while (j < s.length()) {
      for (j++; j < s.length() && s.charAt(j) != s.charAt(i); j++) {
        if (T.containsKey(s.charAt(j))) {
          minWindow_map_put(window, s.charAt(j));
        }
      }
      if (j < s.length() && s.charAt(j) == s.charAt(i)) {
        i++;
        i = minWindow_i(s, T, i, window);
        if (j - i + 1 < minLen) {
          minLen = j - i + 1;
          ret = s.substring(i, j + 1);
        }
      }
    }
    return ret;
  }
}
------------
public class Solution {
  public String minWindow(String s, String t) {
    Map<Integer, Long> m = t.chars().boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    String ret = null;
    int last = 0;
    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i);
      if (m.containsKey(c)) {
        m.put(c, m.get(c) - 1); // offer
        if (m.get(c) <= 0 && m.values().stream().filter(x -> x > 0).count() == 0) { // find complete window
          while (last < s.length()
              && (!m.containsKey((int) s.charAt(last)) || m.get((int) s.charAt(last)) + 1 <= 0)) { // shrink
            if (m.containsKey((int) s.charAt(last))) {
              int d = s.charAt(last);
              m.put(d, m.get(d) + 1); // poll
            }
            last++;
          }
          if (ret != null) { // compare
            if ((i + 1) - last < ret.length()) {
              ret = s.substring(last, i + 1);
            }
          } else {
            ret = s.substring(last, i + 1);
          }
        }
      }
    }
    if (ret == null)
      return "";
    return ret;
  }
}
