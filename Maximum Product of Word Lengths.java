import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  public int maxProduct(String[] words) {
    Map<Character, Set<String>> a2z = new HashMap<>();
    for (char c = 'a'; c <= 'z'; c++) {
      a2z.put(c, new HashSet<String>());
    }
    for (String w : words) {
      for (int i = 0; i < w.length(); i++) {
        a2z.get(w.charAt(i)).add(w);
      }
    }
    int max = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        boolean share = false;
        for (char c = 'a'; c <= 'z'; c++) {
          Set<String> s = a2z.get(c);
          if (s.contains(words[i]) && s.contains(words[j])) {
            share = true;
            break;
          }
        }
        if (!share) {
          max = Math.max(max, words[i].length() * words[j].length());
        }
      }
    }
    return max;
  }
}
