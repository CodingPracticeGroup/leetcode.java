public class Solution {
  public boolean isAnagram(String s, String t) {
    Map<Integer, Long> ss = s.chars().boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Map<Integer, Long> tt = t.chars().boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    return ss.equals(tt);
  }
}
