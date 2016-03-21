public class Solution {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}
----------
public class Solution {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int l = maxDepth(root.left);
    int r = maxDepth(root.right);
    return 1 + Math.max(l, r);
  }
}
