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
-------------
public class Solution {
  boolean is(TreeNode r1, TreeNode r2) {
    if (r1 == null && r2 == null)
      return true;
    if (r1 == null || r2 == null)
      return false;
    if (r1.val != r2.val)
      return false;
    return is(r1.left, r2.right) && is(r1.right, r2.left);
  }

  public boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;
    return is(root.left, root.right);
  }
}
