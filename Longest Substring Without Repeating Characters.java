import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int lengthOfLongestSubstring(String s) {
    int ret = -1;
    Set<Character> memory = new HashSet<Character>();
    for (int i = 0, j = 0; j < s.length(); j++) {
      char c = s.charAt(j);
      if (memory.contains(c)) {
        ret = Math.max(ret, memory.size());
        while (s.charAt(i) != c) {
          memory.remove(s.charAt(i++));
        }
        memory.remove(s.charAt(i++));
      }
      memory.add(c);
    }
    ret = Math.max(ret, memory.size());
    return ret;
  }
}
