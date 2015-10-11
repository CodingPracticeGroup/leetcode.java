public class Solution {
  private String generateParenthesis_insert(String str, int pos) {
    return new String(str.substring(0, pos) + "()" + str.substring(pos));
  }

  private Set<String> generateParenthesis_hashset(int n) {
    Set<String> ret = new HashSet<>();
    if (n == 1) {
      ret.add("()");
      return ret;
    }
    Set<String> l = generateParenthesis_hashset(n - 1);
    for (String s : l) {
      for (int i = 0; i <= s.length(); i++) {
        ret.add(generateParenthesis_insert(s, i));
      }
    }
    return ret;
  }

  public List<String> generateParenthesis(int n) {
    return new ArrayList<String>(generateParenthesis_hashset(n));
  }
}
