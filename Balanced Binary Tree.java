public class Solution {
  // info[0] height; info[1] balanced
  private void isBalanced_(TreeNode root, int[] info) {
    if (root != null) {
      int[] leftinfo = new int[2];
      isBalanced_(root.left, leftinfo);
      int[] rightinfo = new int[2];
      isBalanced_(root.right, rightinfo);
      if (leftinfo[1] == 1 && rightinfo[1] == 1 && Math.abs(leftinfo[0] - rightinfo[0]) <= 1) {
        info[1] = 1;
      } else {
        info[1] = 0;
      }
      info[0] = Math.max(leftinfo[0], rightinfo[0]) + 1;
    } else {
      info[0] = 0;
      info[1] = 1; // true
    }
  }

  public boolean isBalanced(TreeNode root) {
    int[] info = new int[2];
    isBalanced_(root, info);
    return info[1] == 1;
  }
}
