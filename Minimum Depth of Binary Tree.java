public class Solution {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    } else if (root.left == null && root.right == null) {
      return 1;
    }
    int left = Integer.MAX_VALUE;
    if (root.left != null) {
      left = minDepth(root.left);
    }
    int right = Integer.MAX_VALUE;
    if (root.right != null) {
      right = minDepth(root.right);
    }
    return Math.min(left, right) + 1;
  }
}
