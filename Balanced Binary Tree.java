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
----------------
public class Solution {
  int[] dfs(TreeNode root) { // [balanced, depth]
    if (root == null) {
      return new int[] {1, 0};
    }
    int[] l = dfs(root.left);
    int[] r = dfs(root.right);
    int balanced = l[0] == 1 && r[0] == 1 && Math.abs(l[1] - r[1]) <= 1 ? 1 : 0;
    int depth = 1 + Math.max(l[1], r[1]);
    return new int[] {balanced, depth};
  }

  public boolean isBalanced(TreeNode root) {
    int[] ret = dfs(root);
    return ret[0] == 1;
  }
}
