public class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    Set<String> once = new HashSet<>();
    Set<String> twice = new HashSet<>();
    for (int i = 0; i + 10 <= s.length(); i++) {
      String ss = s.substring(i, i + 10);
      if (once.contains(ss))
        twice.add(ss);
      else
        once.add(ss);
    }
    return new ArrayList<String>(twice);
  }
}
