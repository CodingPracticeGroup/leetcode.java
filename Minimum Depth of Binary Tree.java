public class Solution {
  private void minDepth_(TreeNode root, int level, int[] ret) {
    if (root.left == null && root.right == null) { // leaf
      ret[0] = Math.min(ret[0], level);
    } else {
      if (root.left != null) {
        minDepth_(root.left, level + 1, ret);
      }
      if (root.right != null) {
        minDepth_(root.right, level + 1, ret);
      }
    }
  }

  public int minDepth(TreeNode root) {
    if (root == null)
      return 0;
    int[] ret = new int[1];
    ret[0] = Integer.MAX_VALUE;
    minDepth_(root, 1, ret);
    return ret[0];
  }
}
