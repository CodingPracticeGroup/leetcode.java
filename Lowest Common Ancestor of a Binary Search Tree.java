public class Solution {
  private void lowestCommonAncestor_(TreeNode root, TreeNode p, List<TreeNode> ret,
      Deque<TreeNode> stack) {
    if (ret.size() == 0) { // prune
      stack.offerLast(root);
      if (root == p) { // report
        ret.addAll(stack);
      } else {
        if (p.val < root.val) { // prune
          lowestCommonAncestor_(root.left, p, ret, stack); // explore
        } else if (root.val < p.val) { // prune
          lowestCommonAncestor_(root.right, p, ret, stack); // explore
        }
      }
      stack.pollLast();
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> path_p = new ArrayList<>();
    lowestCommonAncestor_(root, p, path_p, new ArrayDeque<TreeNode>());
    List<TreeNode> path_q = new ArrayList<>();
    lowestCommonAncestor_(root, q, path_q, new ArrayDeque<TreeNode>());
    int len = Math.min(path_p.size(), path_q.size());
    for (int i = 0; i < len; i++) {
      if (path_p.get(i) != path_q.get(i)) {
        return path_p.get(i - 1);
      }
    }
    if (len == path_p.size()) {
      return path_p.get(len - 1);
    } else {
      return path_q.get(len - 1);
    }
  }
}
