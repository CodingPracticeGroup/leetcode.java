public class Solution {
  private int calculate(Deque<String> s) {
    int ret = Integer.parseInt(s.pollFirst());
    while (!s.isEmpty()) {
      String op = s.pollFirst();
      String rnd = s.pollFirst();
      if (op.equals("+")) {
        ret += Integer.parseInt(rnd);
      } else if (op.equals("-")) {
        ret -= Integer.parseInt(rnd);
      }
    }
    return ret;
  }

  public int calculate(String s) {
    s = s.replaceAll("\\s+", "");
    s = s.replaceAll("\\+", " \\+ ");
    s = s.replaceAll("\\-", " \\- ");
    s = s.replaceAll("\\*", " \\* ");
    s = s.replaceAll("\\/", " \\/ ");
    s = s.replaceAll("\\(", " \\( ");
    s = s.replaceAll("\\)", " \\) ");
    s = s.replaceAll("\\s+", " ");
    s = s.trim();
    String ss[] = s.split(" ");

    Deque<String> stack = new ArrayDeque<>();
    for (String str : ss) {
      if (str.equals(")")) {
        Deque<String> tmp = new ArrayDeque<>();
        while (!stack.peekLast().equals("(")) {
          tmp.offerFirst(stack.pollLast());
        }
        stack.pollLast();
        stack.offerLast(String.valueOf(calculate(tmp)));
      } else {
        stack.offerLast(str);
      }
    }
    return calculate(stack);
  }
}
