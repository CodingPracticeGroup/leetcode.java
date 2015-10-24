public class Solution {
  public int hIndex(int[] citations) {
    Map<Integer, Long> map =
        Arrays.stream(citations).boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    long total = map.values().stream().reduce(0L, Long::sum);
    long left = map.containsKey(0) ? total - map.get(0) : total;
    for (int i = 1; i <= citations.length; i++) {
      if (left >= i) {
        if (map.containsKey(i)) {
          left -= map.get(i);
        }
      } else {
        return i - 1;
      }
    }
    return citations.length;
  }
}
