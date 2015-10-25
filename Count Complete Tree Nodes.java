public class Solution {
  private int countNodes_perfect(TreeNode root) {
    int cnt_left = 0;
    for (TreeNode p = root; p != null; p = p.left) {
      cnt_left++;
    }
    int cnt_right = 0;
    for (TreeNode p = root; p != null; p = p.right) {
      cnt_right++;
    }
    if (cnt_left == cnt_right)
      return cnt_left;
    return -1;
  }

  public int countNodes(TreeNode root) {
    int h = countNodes_perfect(root);
    if (h == -1)
      return 1 + countNodes(root.left) + countNodes(root.right);
    else
      return (1 << h) - 1;
  }
}
