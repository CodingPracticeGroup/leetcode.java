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
-------------
/****************
this cannot pass large set
****************/
public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<Map<Integer, Long>, List<String>> es = new HashMap<>();
    for (String s : strs) {
      Map<Integer, Long> m = s.chars().boxed()
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
      if (!es.containsKey(m)) {
        es.put(m, new ArrayList<String>());
      }
      es.get(m).add(s);
    }
    for (List<String> l : es.values()) {
      Collections.sort(l);
    }
    return new ArrayList<List<String>>(es.values());
  }
}
---------------
public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    return Arrays.stream(strs).collect(Collectors.groupingBy(x -> {
      char[] ca = x.toCharArray();
      Arrays.sort(ca);
      return new String(ca);
    })).values().stream().map(x -> {
      Collections.sort(x);
      return x;
    }).collect(Collectors.toList());
  }
}
