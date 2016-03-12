public class Solution {
  int[] rob1(TreeNode root) { // [0] root inclusive, [1] root exclusive
    if (root == null) {
      // return new int[] {0, 0};
      return new int[2];
    }

    int l[] = rob1(root.left);
    int r[] = rob1(root.right);

    // return new int[] {root.val + l[1] + r[1], Arrays
    // .stream(new int[] {l[0] + r[0], l[1] + r[1], l[0] + r[1], l[1] + r[0]}).max().getAsInt()};
    return new int[] {root.val + l[1] + r[1], Math.max(l[0], l[1]) + Math.max(r[0], r[1])};
  }

  public int rob(TreeNode root) {
    int[] ret = rob1(root);
    return Math.max(ret[0], ret[1]);
  }
}
