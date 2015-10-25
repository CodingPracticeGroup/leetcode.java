public class Solution {
  public int calculate(String s) {
    s = s.replaceAll("\\s*", "");
    s = s.replaceAll("\\+", " \\+ ");
    s = s.replaceAll("\\-", " \\- ");
    s = s.replaceAll("\\*", " \\* ");
    s = s.replaceAll("\\/", " \\/ ");
    s = s.trim();
    String ss[] = s.split(" ");
    Deque<String> stack = new ArrayDeque<>();
    for (int i = 0; i < ss.length; i++) {
      if (ss[i].equals("*")) {
        stack.offerLast(String.valueOf(Integer.parseInt(stack.pollLast())
            * Integer.parseInt(ss[i + 1])));
        i++;
      } else if (ss[i].equals("/")) {
        stack.offerLast(String.valueOf(Integer.parseInt(stack.pollLast())
            / Integer.parseInt(ss[i + 1])));
        i++;
      } else {
        stack.offerLast(ss[i]);
      }
    }
    int ret = Integer.parseInt(stack.pollFirst());
    while (!stack.isEmpty()) {
      String op = stack.pollFirst();
      String rnd = stack.pollFirst();
      if (op.equals("+")) {
        ret += Integer.parseInt(rnd);
      } else if (op.equals("-")) {
        ret -= Integer.parseInt(rnd);
      }
    }
    return ret;
  }
}
