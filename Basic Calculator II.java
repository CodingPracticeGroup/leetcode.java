public class Solution {
  public int calculate(String s) {
    s = s.replaceAll("\\s+", "");
    s = s.replaceAll("\\+", " \\+ ");
    s = s.replaceAll("\\-", " \\- ");
    s = s.replaceAll("\\*", " \\* ");
    s = s.replaceAll("\\/", " \\/ ");
    String ss[] = s.split(" ");
    Deque<String> stack = new ArrayDeque<>();
    for (int i = 0; i < ss.length; i++) {
      if (ss[i].equals("*")) {
        int o1 = Integer.parseInt(stack.pollLast());
        int o2 = Integer.parseInt(ss[++i]);
        stack.offerLast(String.valueOf(o1 * o2));
      } else if (ss[i].equals("/")) {
        int o1 = Integer.parseInt(stack.pollLast());
        int o2 = Integer.parseInt(ss[++i]);
        stack.offerLast(String.valueOf(o1 / o2));
      } else {
        stack.offerLast(ss[i]);
      }
    }
    int ret = Integer.parseInt(stack.pollFirst());
    while (!stack.isEmpty()) {
      String op = stack.pollFirst();
      int rnd = Integer.parseInt(stack.pollFirst());
      if (op.equals("+")) {
        ret += rnd;
      } else if (op.equals("-")) {
        ret -= rnd;
      }
    }
    return ret;
  }
}
