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
--------------
public class Solution {
  public int calculate(String s) {
    s = s.replaceAll("\\s+", "");
    s = s.trim();

    s = s.replaceAll("\\+", " \\+ ");
    s = s.replaceAll("\\-", " \\- ");
    s = s.replaceAll("\\*", " \\* ");
    s = s.replaceAll("\\/", " \\/ ");

    String[] strs = s.split(" ");

    Deque<String> stack = new ArrayDeque<>();
    for (int i = 0; i < strs.length; i++) {
      if (strs[i].equals("*")) {
        stack.offerLast(
            String.valueOf(Integer.valueOf(stack.pollLast()) * Integer.valueOf(strs[++i])));
      } else if (strs[i].equals("/")) {
        stack.offerLast(
            String.valueOf(Integer.valueOf(stack.pollLast()) / Integer.valueOf(strs[++i])));
      } else {
        stack.offerLast(strs[i]);
      }
    }
    int ret = Integer.parseInt(stack.pollFirst());
    while (!stack.isEmpty()) {
      String str = stack.pollFirst();
      if (str.equals("+")) {
        ret += Integer.parseInt(stack.pollFirst());
      } else if (str.equals("-")) {
        ret -= Integer.parseInt(stack.pollFirst());
      }
    }
    return ret;
  }
}
