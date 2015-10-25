public class Solution {
  private boolean addOperators_calc(int target, Deque<String> stack) {
    Deque<String> calc_stack = new ArrayDeque<>();
    for (String s : stack) {
      if (!calc_stack.isEmpty() && calc_stack.peekLast().equals("*")) {
        long oprnd2 = Long.parseLong(s);
        calc_stack.pollLast();
        long oprnd1 = Long.parseLong(calc_stack.pollLast());
        calc_stack.offerLast(String.valueOf(oprnd1 * oprnd2));
      } else {
        calc_stack.offerLast(s);
      }
    }

    long sum = Long.parseLong(calc_stack.pollFirst());
    while (!calc_stack.isEmpty()) {
      String op = calc_stack.pollFirst();
      String rnd = calc_stack.pollFirst();
      if (op.equals("+"))
        sum += Long.parseLong(rnd);
      else
        sum -= Long.parseLong(rnd);
    }
    return target == sum;
  }

  private void addOperators_bt(String num, int target, List<String> ret, Deque<String> stack,
      int start) {
    if (start == num.length() && addOperators_calc(target, stack)) {
      ret.add(stack.stream().reduce("", (acc, e) -> acc + e));
    } else {
      for (int i = start + 1; i <= num.length(); i++) {
        String str = num.substring(start, i);
        if (addOperators_check(str)) {
          stack.offerLast("+");
          stack.offerLast(str);
          addOperators_bt(num, target, ret, stack, i);
          stack.pollLast();
          stack.pollLast();

          stack.offerLast("-");
          stack.offerLast(str);
          addOperators_bt(num, target, ret, stack, i);
          stack.pollLast();
          stack.pollLast();

          stack.offerLast("*");
          stack.offerLast(str);
          addOperators_bt(num, target, ret, stack, i);
          stack.pollLast();
          stack.pollLast();
        }
      }
    }
  }

  private boolean addOperators_check(String str) {
    if (str.length() >= 2 && str.charAt(0) == '0')
      return false;
    return true;
  }

  public List<String> addOperators(String num, int target) {
    List<String> ret = new ArrayList<>();
    Deque<String> stack = new LinkedList<String>();
    for (int i = 1; i <= num.length(); i++) {
      String s = num.substring(0, i);
      if (addOperators_check(s)) {
        stack.offerLast(s);
        addOperators_bt(num, target, ret, stack, i);
        stack.pollLast();
      }
    }
    return ret;
  }
}
