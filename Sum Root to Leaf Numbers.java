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
