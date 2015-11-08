public class Solution {
  public int hIndex(int[] citations) {
    Map<Integer, Long> map =
        Arrays.stream(citations).boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    long dp[] = new long[citations.length + 1];
    for (int i = 0; i <= citations.length; i++) {
      dp[i] = (i - 1 >= 0 ? dp[i - 1] : 0) + (map.containsKey(i) ? map.get(i) : 0);
    }
    for (int h = citations.length; h >= 1; h--) {
      if (citations.length - dp[h - 1] >= h)
        return h;
    }
    return 0;
  }
}
