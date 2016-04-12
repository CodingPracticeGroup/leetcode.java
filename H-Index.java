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
---------------
public class Solution {
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int idx = citations.length - 1;
    for (int h = citations.length; h >= 1; h--) {
      if (citations[citations.length - h] >= h) {
        return h;
      }
    }
    return 0;
  }
}
-------------
public class Solution {
  public int hIndex(int[] citations) {
    int length = citations.length;
    if (length == 0) {
      return 0;
    }

    int[] array2 = new int[length + 1];
    for (int i = 0; i < length; i++) {
      if (citations[i] > length) {
        array2[length] += 1;
      } else {
        array2[citations[i]] += 1;
      }
    }
    int t = 0;
    for (int i = length; i >= 0; i--) {
      t = t + array2[i];
      if (t >= i) {
        return i;
      }
    }
    return 0;
  }
}
-----------------
public class Solution {
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    for (int h = citations.length; h > 0; h--) {
      if (citations[citations.length - h] >= h) {
        return h;
      }
    }
    return 0;
  }
}
