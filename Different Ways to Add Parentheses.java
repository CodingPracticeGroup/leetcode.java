public class Solution {
  private List<Integer> diffWaysToCompute(String input, int start, int end) {
    List<Integer> ret = new ArrayList<>();
    for (int i = start; i < end; i++) {
      if (input.charAt(i) == '+') {
        List<Integer> left = diffWaysToCompute(input, start, i);
        List<Integer> right = diffWaysToCompute(input, i + 1, end);
        for (int j : left) {
          for (int k : right) {
            ret.add(j + k);
          }
        }
      } else if (input.charAt(i) == '-') {
        List<Integer> left = diffWaysToCompute(input, start, i);
        List<Integer> right = diffWaysToCompute(input, i + 1, end);
        for (int j : left) {
          for (int k : right) {
            ret.add(j - k);
          }
        }
      } else if (input.charAt(i) == '*') {
        List<Integer> left = diffWaysToCompute(input, start, i);
        List<Integer> right = diffWaysToCompute(input, i + 1, end);
        for (int j : left) {
          for (int k : right) {
            ret.add(j * k);
          }
        }
      }
    }
    if (ret.isEmpty()) {
      ret.add(Integer.parseInt(input.substring(start, end)));
    }
    return ret;
  }

  public List<Integer> diffWaysToCompute(String input) {
    return diffWaysToCompute(input, 0, input.length());
  }
}
