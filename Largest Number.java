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
