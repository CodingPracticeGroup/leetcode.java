public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> ret =
        new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(x -> {
          char[] ca = x.toCharArray();
          Arrays.sort(ca);
          return new String(ca);
        })).values());
    for (List<String> ls : ret) {
      Collections.sort(ls);
    }
    ret.sort((x, y) -> x.get(0).compareTo(y.get(0)));
    return ret;
  }
}
