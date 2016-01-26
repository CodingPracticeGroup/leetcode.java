public class Solution {
  private int sumNumbers_int(Deque<Integer> stack) {
    StringBuilder sb = new StringBuilder();
    for (Integer i : stack) {
      sb.append(i);
    }
    return Integer.valueOf(sb.toString());
  }

  private void sumNumbers_(TreeNode root, int info[], Deque<Integer> stack) {
    if (root.left == null && root.right == null) {
      stack.offerLast(root.val);
      info[0] += sumNumbers_int(stack);
      stack.pollLast();
    } else {
      if (root.left != null) {
        stack.offerLast(root.val);
        sumNumbers_(root.left, info, stack);
        stack.pollLast();
      }
      if (root.right != null) {
        stack.offerLast(root.val);
        sumNumbers_(root.right, info, stack);
        stack.pollLast();
      }
    }
  }

  public int sumNumbers(TreeNode root) {
    if (root == null)
      return 0;
    int info[] = new int[1];
    sumNumbers_(root, info, new ArrayDeque<Integer>());
    return info[0];
  }
}
-----------
public class Solution {
  private void sn(TreeNode root, int[] ret, LinkedList<TreeNode> stack) {
    if (root == null) {
      return;
    }
    stack.offerLast(root);
    if (root.left == null && root.right == null) {
      StringBuilder sb = new StringBuilder();
      for (TreeNode tn : stack) {
        sb.append(tn.val);
      }
      ret[0] += Integer.parseInt(sb.toString());
    } else {
      sn(root.left, ret, stack);
      sn(root.right, ret, stack);
    }
    stack.pollLast();
  }

  public int sumNumbers(TreeNode root) {
    int ret[] = new int[1];
    sn(root, ret, new LinkedList<TreeNode>());
    return ret[0];
  }
}
