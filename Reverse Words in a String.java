public class Solution {
  public String reverseWords(String s) {
    String[] strarr = s.trim().split(" ");
    return IntStream.range(0, strarr.length).mapToObj(x -> strarr[strarr.length - 1 - x])
        .reduce((x, y) -> {
          if (x.equals("") && y.equals("")) {
            return "";
          } else if (x.equals("")) {
            return y;
          } else if (y.equals("")) {
            return x;
          } else {
            return x + " " + y;
          }
        }).get();
  }
}
