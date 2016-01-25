public class Solution {
  public List<String> generateParenthesis(int n) {
    Set<String> ret = new HashSet<>();
    if (n == 1) {
      ret.add("()");
      return new ArrayList<String>(ret);
    }
    for (String s : generateParenthesis(n - 1)) {
      for (int i = 0; i <= s.length(); i++) {
        ret.add(s.substring(0, i) + "()" + s.substring(i));
      }
    }
    return new ArrayList<String>(ret);
  }
}
