public class Solution {
  private int calculate_(Deque<String> s) { // 同级，用这种更简洁
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
      if (ss[i].equals(")")) { // 锚
        Deque<String> tmp = new ArrayDeque<>();
        while (!stack.peekLast().equals("(")) { // last
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
----------------
public class Solution {
  private String calc(List<String> strList) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < strList.size(); i++) {
      if (strList.get(i).equals("+")) {
        stack.offerLast(stack.pollLast() + Integer.parseInt(strList.get(++i)));
      } else if (strList.get(i).equals("-")) {
        stack.offerLast(stack.pollLast() - Integer.parseInt(strList.get(++i)));
      } else {
        stack.offerLast(Integer.parseInt(strList.get(i)));
      }
    }
    return String.valueOf(stack.poll());
  }

  public int calculate(String s) {
    s = s.replaceAll(" ", "");
    s = s.replaceAll("\\+", " \\+ ");
    s = s.replaceAll("-", " - ");
    s = s.replaceAll("\\(", "\\( ");
    s = s.replaceAll("\\)", " \\)");
    String strs[] = s.split(" ");

    Deque<List<String>> stacks = new ArrayDeque<>();
    stacks.offerLast(new ArrayList<String>());
    for (String str : strs) {
      if (str.equals("(")) { // 锚
        stacks.offerLast(new ArrayList<String>());
      } else if (str.equals(")")) { // next
        List<String> list = stacks.pollLast();
        stacks.peekLast().add(calc(list));
      } else {
        stacks.peekLast().add(str);
      }
    }
    return Integer.parseInt(calc(stacks.pollLast()));
  }
}
------------
public class Solution {
  private String calc(String s) {
    s = s.replaceAll("\\+", " \\+");
    s = s.replaceAll("-", " -");
    s = s.replaceAll("^ ", "");
    String strs[] = s.split(" ");
    return String.valueOf(Arrays.stream(strs).mapToInt(Integer::parseInt).sum());
  }

  public int calculate(String s) {
    s = s.replaceAll(" ", "");
    s = s.replaceAll("\\+", " \\+ ");
    s = s.replaceAll("-", " - ");
    s = s.replaceAll("\\(", "\\( ");
    s = s.replaceAll("\\)", " \\)");
    String strs[] = s.split(" ");

    Deque<StringBuilder> stacks = new ArrayDeque<>();
    stacks.offerLast(new StringBuilder());
    for (String str : strs) {
      if (str.equals("(")) {
        stacks.offerLast(new StringBuilder());
      } else if (str.equals(")")) {
        StringBuilder sb = stacks.pollLast();
        String r = calc(sb.toString());
        if (r.charAt(0) == '-' && stacks.peekLast().length() > 0) {
          if (stacks.peekLast().charAt(stacks.peekLast().length() - 1) == '-') {
            stacks.peekLast().setLength(stacks.peekLast().length() - 1);
            stacks.peekLast().append("+" + r.substring(1));
          } else if (stacks.peekLast().charAt(stacks.peekLast().length() - 1) == '+') {
            stacks.peekLast().setLength(stacks.peekLast().length() - 1);
            stacks.peekLast().append(r);
          }
        } else {
          stacks.peekLast().append(r);
        }
      } else {
        stacks.peekLast().append(str);
      }
    }
    return Integer.parseInt(calc(stacks.pollLast().toString()));
  }
}
