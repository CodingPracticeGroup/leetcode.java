import java.util.Arrays;

public class Solution {
  private int largestNumber_comparator(String xstr, String ystr) {
    int minlen = Math.min(xstr.length(), ystr.length());
    for (int i = 0; i < minlen; i++) {
      if (xstr.charAt(i) != ystr.charAt(i))
        return ystr.charAt(i) - xstr.charAt(i);
    }
    if (minlen == xstr.length() && minlen == ystr.length())
      return 0;
    if (minlen == xstr.length()) { // y is longer
      return largestNumber_comparator(xstr, ystr.substring(minlen));
    } else { // x is longer
      return largestNumber_comparator(xstr.substring(minlen), ystr);
    }
  }

  public String largestNumber(int[] nums) {
    Object nums_[] =
        Arrays.stream(nums).mapToObj(x -> String.valueOf(x)).sorted(this::largestNumber_comparator)
            .toArray();
    StringBuilder sb = new StringBuilder();
    for (Object i : nums_) {
      sb.append(i);
    }
    int idx = 0;
    while (idx < sb.length() && sb.charAt(idx) == '0')
      idx++;
    if (idx == sb.length())
      return "0";
    else
      return sb.substring(idx);
  }
}
------------
public class Solution {
  private int c(String x, String y) {
    int i = 0;
    int j = 0;
    while (i < x.length() && j < y.length()) {
      if (x.charAt(i) != y.charAt(j)) {
        return -(x.charAt(i) - y.charAt(j));
      }
      i++;
      j++;
    }
    if (i < x.length()) {
      return c(x.substring(y.length()), y);
    }
    if (j < y.length()) {
      return c(x, y.substring(x.length()));
    }
    return 0;
  }

  public String largestNumber(int[] nums) {
    StringBuilder ret =
        new StringBuilder(Arrays.stream(nums).mapToObj(x -> String.valueOf(x)).sorted((x, y) -> {
          return c(x, y);
        }).reduce("", (x, y) -> x + y));
    while (ret.length() > 1 && ret.charAt(0) == '0') {
      ret.deleteCharAt(0);
    }
    return ret.toString();
  }
}
--------------
public class Solution {
  public String largestNumber(int[] num) {
    String[] array = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
    Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
    return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
  }
}
