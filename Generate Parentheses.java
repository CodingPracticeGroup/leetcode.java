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

  public ArrayList<String> generateParenthesis_(int n) {
    ArrayList<String> ret = new ArrayList<String>();
    StringBuilder str = new StringBuilder();
    dfs(ret, str, 0, 0, n);
    return ret;
  }

  public void dfs(ArrayList<String> ret, StringBuilder str, int left, int right, int n) {
    if (left == n && right == n) {
      ret.add(str.toString());
      return;
    }
    if (left < n) {
      str.append('(');
      dfs(ret, str, left + 1, right, n);
      str.deleteCharAt(str.length() - 1);
    }
    if (right < left) {
      str.append(')');
      dfs(ret, str, left, right + 1, n);
      str.deleteCharAt(str.length() - 1);
    }
  }
}
