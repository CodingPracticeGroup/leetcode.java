public class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null)
      return false;
    if (root.left == null && root.right == null && sum == root.val) { // leaf
      return true;
    }
    if (root.left != null && hasPathSum(root.left, sum - root.val))
      return true;
    if (root.right != null && hasPathSum(root.right, sum - root.val))
      return true;
    return false;
  }

  public boolean hasPathSum_(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null && sum == root.val) {
      return true;
    }
    boolean left = false;
    if (root.left != null) {
      left = hasPathSum(root.left, sum - root.val);
    }
    boolean right = false;
    if (root.right != null) {
      right = hasPathSum(root.right, sum - root.val);
    }
    return left || right;
  }
}
-------------------
public class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null)
      return false; // special case for the invalid input
    if (root.left == null && root.right == null && root.val == sum)
      return true;
    if (root.left != null && hasPathSum(root.left, sum - root.val))
      return true;
    if (root.right != null && hasPathSum(root.right, sum - root.val))
      return true;
    return false;
  }
}
