public class Solution {
  private List<Integer> diffWaysToCompute_bi_re(String input, int start, int end,
      Map<String, List<Integer>> mem) {
    String key = input.substring(start, end);
    if (mem.containsKey(key)) {
      return mem.get(key);
    }
    List<Integer> ret = new ArrayList<>();
    for (int i = start; i < end; i++) {
      List<Integer> left = diffWaysToCompute_bi_re(input, start, i, mem);
      List<Integer> right = diffWaysToCompute_bi_re(input, i + 1, end, mem);
      if (input.charAt(i) == '+') {
        for (Integer j : left)
          for (Integer k : right)
            ret.add(j + k);
      } else if (input.charAt(i) == '-') {
        for (Integer j : left)
          for (Integer k : right)
            ret.add(j - k);
      } else if (input.charAt(i) == '*') {
        for (Integer j : left)
          for (Integer k : right)
            ret.add(j * k);
      }
    }
    if (ret.size() == 0) {
      if (start == end)
        ret.add(0);
      else
        ret.add(Integer.parseInt(input.substring(start, end)));
    }
    mem.put(key, ret);
    return ret;
  }

  public List<Integer> diffWaysToCompute(String input) {
    return diffWaysToCompute_bi_re(input, 0, input.length(), new HashMap<String, List<Integer>>());
  }
}
-----------
public class Solution {
  private List<Integer> d(String input, int start, int end) {
    List<Integer> ret = new ArrayList<>();
    for (int i = start; i < end; i++) {
      if (!('0' <= input.charAt(i) && input.charAt(i) <= '9')) {
        List<Integer> left = d(input, start, i);
        List<Integer> right = d(input, i + 1, end);
        if (input.charAt(i) == '+') {
          for (int m : left) {
            for (int n : right) {
              ret.add(m + n);
            }
          }
        } else if (input.charAt(i) == '-') {
          for (int m : left) {
            for (int n : right) {
              ret.add(m - n);
            }
          }
        } else if (input.charAt(i) == '*') {
          for (int m : left) {
            for (int n : right) {
              ret.add(m * n);
            }
          }
        }
      }
    }
    if (ret.isEmpty()) {
      ret.add(Integer.valueOf(input.substring(start, end)));
    }
    return ret;
  }

  public List<Integer> diffWaysToCompute(String input) {
    return d(input, 0, input.length());
  }
}
