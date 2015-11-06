public class Solution {
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char sc = s.charAt(i);
      char tc = t.charAt(i);
      if (map.containsKey(sc)) {
        if (!map.get(sc).equals(new Character(tc))) {
          return false;
        }
      } else {
        map.put(sc, tc);
      }
    }
    return map.values().stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values()
        .stream().filter(x -> x > 1).count() == 0;
  }
}
