public class Solution {
  public String reverseWords(String s) {
    String[] strarr = s.trim().replaceAll("\\s+", " ").split(" ");
    return IntStream.range(0, strarr.length).mapToObj(x -> strarr[strarr.length - 1 - x])
        .reduce((x, y) -> x + " " + y).get();
  }
}
--------------
public class Solution {
  public String reverseWords(String s) {
    s = s.trim();
    s = s.replaceAll("\\s+", " ");
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      sb.append(s.charAt(i));
    }
    int i = 0;
    while (i < sb.length()) {
      while (i < sb.length() && sb.charAt(i) == ' ') {
        i++;
      }
      int j = i + 1;
      while (j < sb.length() && sb.charAt(j) != ' ') {
        j++;
      }
      for (int l = i, r = j - 1; l < r; l++, r--) {
        char c = sb.charAt(l);
        sb.setCharAt(l, sb.charAt(r));
        sb.setCharAt(r, c);
      }
      i = j;
    }
    return sb.toString();
  }
}
