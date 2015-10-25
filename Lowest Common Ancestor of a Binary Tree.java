public class Solution {
  private void lowestCommonAncestor(TreeNode root, TreeNode r, Deque<TreeNode> ret,
      Deque<TreeNode> stack) {
    if (root != null) {
      stack.offerLast(root);
      if (root == r) {
        ret.addAll(stack);
      } else {
        lowestCommonAncestor(root.left, r, ret, stack);
        lowestCommonAncestor(root.right, r, ret, stack);
      }
      stack.pollLast();
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Deque<TreeNode> p_path = new ArrayDeque<>();
    lowestCommonAncestor(root, p, p_path, new ArrayDeque<TreeNode>());
    Deque<TreeNode> q_path = new ArrayDeque<>();
    lowestCommonAncestor(root, q, q_path, new ArrayDeque<TreeNode>());
    TreeNode last = root;
    p_path.pollFirst();
    q_path.pollFirst();
    while (!p_path.isEmpty()) {
      TreeNode ptn = p_path.pollFirst();
      TreeNode qtn = q_path.pollFirst();
      if (ptn != qtn)
        return last;
      last = ptn;
    }
    return last;
  }
}