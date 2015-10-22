public class Solution {
  private void lowestCommonAncestor_path(TreeNode root, TreeNode p, List<TreeNode> ret,
      Deque<TreeNode> stack) {
    if (root != null) {
      if (root == p) {
        stack.offerLast(root);
        ret.addAll(stack);
        stack.pollLast();
      } else {
        stack.offerLast(root);
        lowestCommonAncestor_path(root.left, p, ret, stack);
        lowestCommonAncestor_path(root.right, p, ret, stack);
        stack.pollLast();
      }
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> p_path = new ArrayList<>();
    lowestCommonAncestor_path(root, p, p_path, new ArrayDeque<TreeNode>());
    List<TreeNode> q_path = new ArrayList<>();
    lowestCommonAncestor_path(root, q, q_path, new ArrayDeque<TreeNode>());
    int idx = 0;
    while (idx < p_path.size() && idx < q_path.size() && p_path.get(idx) == q_path.get(idx)) {
      idx++;
    }
    if (idx == p_path.size())
      return p;
    if (idx == q_path.size())
      return q;
    return p_path.get(idx - 1);
  }
}