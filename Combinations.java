public class Solution {
  private void combine_bt(int n, int k, int start, Deque<Integer> stack, List<List<Integer>> ret) {
    if (stack.size() == k) {
      ret.add(new ArrayList<Integer>(stack));
    } else {
      for (int i = start; i <= n; i++) {
        if (n - i + 1 >= k - stack.size()) {
          stack.offerLast(i);
          combine_bt(n, k, i + 1, stack, ret);
          stack.pollLast();
        }
      }
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ret = new ArrayList<>();
    combine_bt(n, k, 1, new ArrayDeque<Integer>(), ret);
    return ret;
  }

  private List<List<Integer>> c(int n, int k, int start) {
    List<List<Integer>> ret = new LinkedList<>();
    if (k == 1) {
      for (int i = start; i <= n; i++) { // pick i
        List<Integer> l = new LinkedList<>();
        l.add(i);
        ret.add(l);
      }
      return ret;
    }
    for (int i = start; i <= n; i++) { // pick i
      List<List<Integer>> r = c(n, k - 1, i + 1);
      for (List<Integer> l : r) {
        l.add(0, i);
      }
      ret.addAll(r);
    }
    return ret;
  }

  public List<List<Integer>> combine_(int n, int k) {
    return c(n, k, 1);
  }
}
-----------------
public class Solution {
  List<List<Integer>> c(int n, int startPos, int k) {
    List<List<Integer>> ret = new ArrayList<>(); // return

    if (k == 0) { // termination
      List<Integer> l = new ArrayList<>(); // termination item
      ret.add(l);
      return ret;
    }

    for (int i = startPos; i <= n; i++) { // branch
      List<List<Integer>> r = c(n, i + 1, k - 1); // dfs recursion children
      for (List<Integer> l : r) { // iterate children
        l.add(0, i); // construct
        ret.add(l); // add to current node
      }
    }

    return ret; // default termination
  }

  public List<List<Integer>> combine(int n, int k) {
    return c(n, 1, k);
  }
}
