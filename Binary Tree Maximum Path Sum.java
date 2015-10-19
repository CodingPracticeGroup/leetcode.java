public class Solution {
  private int maxPathSum_max(int... a) {
    int max = Integer.MIN_VALUE;
    for (int i : a) {
      max = Math.max(max, i);
    }
    return max;
  }

  private void maxPathSum_maxdepthsum(TreeNode root, int[] info) {
    // info[0] max depth sum, info[1] max path sum
    if (root != null) {
      int[] left = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
      maxPathSum_maxdepthsum(root.left, left);
      int[] right = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
      maxPathSum_maxdepthsum(root.right, right);
      info[0] = maxPathSum_max(0, left[0] + root.val, right[0] + root.val, root.val);
      info[1] = maxPathSum_max(info[1], left[1], right[1], left[0] + right[0] + root.val);
    } else {
      info[0] = 0;
    }
  }

  public int maxPathSum(TreeNode root) {
    int[] info = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
    maxPathSum_maxdepthsum(root, info);
    return info[1];
  }
}
