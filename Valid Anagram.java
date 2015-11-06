public class Solution {
  public boolean isAnagram(String s, String t) {
    Map<Integer, Long> s_count =
        s.chars().boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Map<Integer, Long> t_count =
        t.chars().boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    if (s_count.size() != t_count.size())
      return false;
    for (Integer i : s_count.keySet()) {
      if (!s_count.get(i).equals(t_count.get(i)))
        return false;
    }
    return true;
  }
}
