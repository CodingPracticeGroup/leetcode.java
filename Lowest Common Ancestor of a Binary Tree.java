public class Solution {
  private void lowestCommonAncestor_bt(TreeNode root, TreeNode p, List<TreeNode> ret,
      Deque<TreeNode> stack) {
    if (root != null) {
      stack.offerLast(root);
      if (root == p) {
        ret.addAll(stack);
      } else {
        if (ret.isEmpty())
          lowestCommonAncestor_bt(root.left, p, ret, stack);
        if (ret.isEmpty())
          lowestCommonAncestor_bt(root.right, p, ret, stack);
      }
      stack.pollLast();
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> pathp = new ArrayList<>();
    lowestCommonAncestor_bt(root, p, pathp, new ArrayDeque<TreeNode>());
    List<TreeNode> pathq = new ArrayList<>();
    lowestCommonAncestor_bt(root, q, pathq, new ArrayDeque<TreeNode>());
    int len = Math.min(pathp.size(), pathq.size());
    for (int i = 0; i < len; i++) {
      if (pathp.get(i) != pathq.get(i)) {
        return pathp.get(i - 1);
      }
    }
    if (len == pathp.size()) {
      return pathp.get(len - 1);
    } else {
      return pathq.get(len - 1);
    }
  }
}
