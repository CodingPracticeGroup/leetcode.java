import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int lengthOfLongestSubstring(String s) {
    int ret = -1;
    Set<Character> memory = new HashSet<Character>();
    for (int i = 0, j = 0; j < s.length(); j++) { // scan j
      char c = s.charAt(j);
      if (memory.contains(c)) {
        ret = Math.max(ret, memory.size());
        while (s.charAt(i) != c) {
          memory.remove(s.charAt(i++)); // i follows j
        }
        memory.remove(s.charAt(i++));
      }
      memory.add(c);
    }
    ret = Math.max(ret, memory.size());
    return ret;
  }
}
---------
public class Solution {
  public int lengthOfLongestSubstring(String s) {
    Set<Character> window = new HashSet<>();
    int ret = 0;
    int i = 0;
    int j = 0;
    while (j < s.length()) {
      while (j < s.length() && !window.contains(s.charAt(j))) {
        window.add(s.charAt(j));
        j++;
      }

      ret = Math.max(ret, j - i);

      if (j != s.length()) {
        while (s.charAt(i) != s.charAt(j)) {
          window.remove(Character.valueOf(s.charAt(i)));
          i++;
        }
        window.remove(Character.valueOf(s.charAt(i++)));
      }
    }
    return ret;
  }
}
