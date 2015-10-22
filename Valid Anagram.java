public class Solution {
  public boolean isAnagram(String s, String t) {
    Map<Integer, Long> s_ =
        s.chars().boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Map<Integer, Long> t_ =
        t.chars().boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    if (s_.size() != t_.size())
      return false;
    for (Integer k : s_.keySet()) {
      if (!t_.containsKey(k))
        return false;
      if (!s_.get(k).equals(t_.get(k)))
        return false;
    }
    return true;
  }
}
