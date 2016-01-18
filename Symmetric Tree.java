public class Solution {
  private boolean mirror(TreeNode l, TreeNode r) {
    if (l == null && r == null) {
      return true;
    } else if (l != null && r != null) {
      return l.val == r.val && mirror(l.left, r.right) && mirror(l.right, r.left);
    }
    return false;
  }

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return mirror(root.left, root.right);
  }
}
