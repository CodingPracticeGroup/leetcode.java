public class Solution {
  private int calculate_(Deque<String> s) {
    int ret = Integer.parseInt(s.pollFirst());
    while (!s.isEmpty()) {
      String op = s.pollFirst();
      int rnd = Integer.parseInt(s.pollFirst());
      if (op.equals("+")) {
        ret += rnd;
      } else if (op.equals("-")) {
        ret -= rnd;
      }
    }
    return ret;
  }

  public int calculate(String s) {
    s = s.replaceAll("\\s+", "");
    s = s.replaceAll("\\+", " \\+ ");
    s = s.replaceAll("\\-", " \\- ");
    s = s.replaceAll("\\(", " \\( ");
    s = s.replaceAll("\\)", " \\) ");
    s = s.trim();
    String ss[] = s.split("\\s+");
    Deque<String> stack = new ArrayDeque<>();
    for (int i = 0; i < ss.length; i++) {
      if (ss[i].equals(")")) {
        Deque<String> tmp = new ArrayDeque<>();
        while (!stack.peekLast().equals("(")) {
          tmp.offerFirst(stack.pollLast());
        }
        stack.pollLast();
        String ts = String.valueOf(calculate_(tmp));
        stack.offerLast(ts);
      } else {
        stack.offerLast(ss[i]);
      }
    }
    return calculate_(stack);
  }
}
