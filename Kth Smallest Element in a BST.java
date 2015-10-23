public class Solution {
  public int kthSmallest(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    for (TreeNode p = root; p != null; p = p.left)
      stack.push(p);
    for (int i = 0; i < k - 1; i++) {
      TreeNode tn = stack.pop(); // visit k-1 times
      for (TreeNode p = tn.right; p != null; p = p.left)
        stack.push(p);
    }
    return stack.pop().val;
  }
}
