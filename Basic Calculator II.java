public class Solution {
  public int calculate(String s) {
    String ss = s.replaceAll("\\s*", "");
    String sss2[] =
        Arrays.stream(ss.split("\\d+")).filter(x -> !x.equals(""))
            .toArray(size -> new String[size]);
    String sss1[] = ss.split("[\\+\\-\\*\\/]");
    Deque<String> stack = new ArrayDeque<>();
    stack.offerLast(sss1[0]);
    for (int i = 0; i < sss2.length; i++) {
      if (sss2[i].equals("*")) {
        stack.offerLast(String.valueOf(Integer.parseInt(stack.pollLast())
            * Integer.parseInt(sss1[i + 1])));
      } else if (sss2[i].equals("/")) {
        stack.offerLast(String.valueOf(Integer.parseInt(stack.pollLast())
            / Integer.parseInt(sss1[i + 1])));
      } else {
        stack.offerLast(sss2[i]);
        stack.offerLast(sss1[i + 1]);
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