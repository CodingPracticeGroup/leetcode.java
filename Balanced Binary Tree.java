public class Solution {
  private int height(TreeNode root, boolean[] ret) {
    if (ret[0] == false) {
      return -1;
    }
    if (root == null) {
      return 0;
    }
    int left = height(root.left, ret);
    int right = height(root.right, ret);
    if (Math.abs(left - right) > 1) {
      ret[0] = false;
    }
    return Math.max(left, right) + 1;
  }

  public boolean isBalanced(TreeNode root) {
    boolean ret[] = new boolean[1];
    ret[0] = true;
    height(root, ret);
    return ret[0];
  }
}
