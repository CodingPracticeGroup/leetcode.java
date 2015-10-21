public class Solution {
  public String reverseWords(String s) {
    String[] strarr = s.trim().replaceAll("\\s+", " ").split(" ");
    return IntStream.range(0, strarr.length).mapToObj(x -> strarr[strarr.length - 1 - x])
        .reduce((x, y) -> x + " " + y).get();
  }
}
