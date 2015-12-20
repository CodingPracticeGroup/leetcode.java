public class Solution {
  int perfect(TreeNode root) {
    int c_l = 0;
    for (TreeNode tn = root; tn.left != null; tn = tn.left) {
      c_l++;
    }
    int c_r = 0;
    for (TreeNode tn = root; tn.right != null; tn = tn.right) {
      c_r++;
    }
    if (c_l == c_r) {
      return c_l;
    } else {
      return -1;
    }
  }

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int h = perfect(root);
    if (h >= 0) {
      return (1 << (h + 1)) - 1; // Math.pow timeout
    } else {
      return countNodes(root.left) + countNodes(root.right) + 1;
    }
  }
}
