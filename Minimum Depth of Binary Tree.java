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
--------------
public class Solution {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
//    if (root.left == null && root.right == null) {
//      return 1;
//    }
    int l = minDepth(root.left);
    int r = minDepth(root.right);
    if (l >= 1 && r >= 1) {
      return Math.min(l, r) + 1;
    } else if (l >= 1) {
      return 1 + l;
    } else if (r >= 1) {
      return r + 1;
    } else {
      return 1;
    }
  }
}
