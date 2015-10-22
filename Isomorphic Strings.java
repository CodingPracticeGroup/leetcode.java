public class Solution {
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> s2t = new HashMap<>();
    Map<Character, Character> t2s = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ss = s.charAt(i);
      char tt = t.charAt(i);
      if (!s2t.containsKey(ss) && !t2s.containsKey(tt)) {
        s2t.put(ss, tt);
        t2s.put(tt, ss);
      } else if (s2t.containsKey(ss) && t2s.containsKey(tt)) {
        if (!s2t.get(ss).equals(tt) || !t2s.get(tt).equals(ss)) {
          return false;
        }
      } else {
        return false;
      }
    }
    return true;
  }
}
