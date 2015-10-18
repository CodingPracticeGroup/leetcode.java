public class Solution {
  private TreeNode flatten_(TreeNode root) {
    TreeNode left = root.left;
    TreeNode right = root.right;
    root.left = null;
    root.right = left;

    TreeNode leftlast = root;
    if (left != null) {
      leftlast = flatten_(left);
    }
    leftlast.right = right;

    TreeNode rightlast = leftlast;
    if (right != null) {
      rightlast = flatten_(right);
    }

    return rightlast;
  }

  public void flatten(TreeNode root) {
    if (root != null) {
      flatten_(root);
    }
  }
}
