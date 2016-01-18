public class Solution {
  LinkedList<TreeNode> rootPath(TreeNode root, TreeNode p) {
    LinkedList<TreeNode> ret = new LinkedList<>();
    while (root != p) {
      ret.offerLast(root);
      if (p.val < root.val) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    ret.offerLast(p);
    return ret;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    LinkedList<TreeNode> pp = rootPath(root, p);
    LinkedList<TreeNode> qq = rootPath(root, q);

    TreeNode ret = null;
    while (pp.peekFirst() == qq.peekFirst()) {
      ret = pp.pollFirst();
      qq.pollFirst();
    }
    return ret;
  }
}
