public class Solution {
  void bt(int k, int n, List<List<Integer>> ret, LinkedList<Integer> stack) {
    if (k == 0 && n == 0) {
      ret.add(new ArrayList<Integer>(stack));
    } else {
      if (k <= 0 || n <= 0) {
        return;
      }
      int last = 0;
      if (!stack.isEmpty()) {
        last = stack.peekLast();
      }
      for (int i = last + 1; i <= 9; i++) {
        stack.offerLast(i);
        bt(k - 1, n - i, ret, stack);
        stack.pollLast();
      }
    }
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ret = new ArrayList<>();
    bt(k, n, ret, new LinkedList<Integer>());
    return ret;
  }
}
---------
public class Solution {
    private List<List<Integer>> c (int k, int n, int start) {
        List<List<Integer>> ret = new ArrayList<>();
        if (k==0 || n==0 || start>9) {
            if (k==0 && n==0) {
                List<Integer> l = new ArrayList<>();
                ret.add(l);
            }
            return ret;
        }
        for (int i=start; i<=9; i++) {
            //List<List<Integer>> r0 = c(k, n, i+1); // not to be
            List<List<Integer>> r1 = c(k-1, n-i, i+1); // to be
            for (List<Integer> l : r1) {
                l.add(0, i);
            }
            //ret.addAll(r0);
            ret.addAll(r1);
        }
        return ret;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        return c (k, n ,1);
    }
}
----------------------
public class Solution {
    List<List<Integer>> c(int k, int startPos, int n) {
        List<List<Integer>> ret = new ArrayList<>(); // return
        
        if (n==0 && k==0) { // termination 
            List<Integer> l = new ArrayList<>(); // termination item
            ret.add(l);
            return ret;
        }

        for (int i=startPos; i<=9 && i<=n; i++) { // explore & prune
            List<List<Integer>> r = c(k-1, i+1, n-i); // dfs recursion
            for (List<Integer> l : r) { // iteration children result
                l.add(0, i); // construct
                ret.add(l); // add to current node result set
            }
        }
        
        return ret; // default termination result
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        return c(k, 1, n);
    }
}