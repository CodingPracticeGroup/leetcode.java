public class Solution {
  private boolean isValidBST_(TreeNode root, long min, long max) {
    if (root == null)
      return true;
    if (min < root.val && root.val < max) {
      return isValidBST_(root.left, min, root.val) && isValidBST_(root.right, root.val, max);
    } else {
      return false;
    }
  }

  public boolean isValidBST(TreeNode root) {
    return isValidBST_(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
  }
}
