import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
  public String removeDuplicateLetters(String s) {
    Map<Character, LinkedList<Integer>> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (!map.containsKey(s.charAt(i))) {
        map.put(s.charAt(i), new LinkedList<>());
      }
      map.get(s.charAt(i)).add(i);
    }
    for (List<Integer> l : map.values()) {
      Collections.sort(l);
    }

    StringBuilder sb = new StringBuilder();
    while (!map.isEmpty()) {
      for (char c = 'a'; c <= 'z'; c++) {
        if (map.containsKey(c)) {
          boolean found = true;
          for (Character ch : map.keySet()) {
            if (ch != c) {
              List<Integer> l = map.get(ch);
              if (l.get(l.size() - 1) < map.get(c).get(0)) {
                found = false;
              }
            }
          }
          if (found) {
            sb.append(c);
            int p = map.get(c).get(0);
            for (LinkedList<Integer> l : map.values()) {
              while (l.peekFirst() < p) {
                l.pollFirst();
              }
            }
            map.remove(c);
            break;
          }
        }
      }
    }
    return sb.toString();
  }
}
