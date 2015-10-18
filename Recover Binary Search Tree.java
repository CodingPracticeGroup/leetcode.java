public class Solution {
  private void recoverTree_leftright(TreeNode root, int[] pre, TreeNode[] leftWrong) {
    if (leftWrong[0] == null && root != null) {
      recoverTree_leftright(root.left, pre, leftWrong);
      if (leftWrong[0] == null) {
        if (!(pre[0] <= root.val)) {
          leftWrong[0] = leftWrong[1];
          return;
        } else {
          pre[0] = root.val;
          leftWrong[1] = root;
        }
        recoverTree_leftright(root.right, pre, leftWrong);
      }
    }
  }

  private void recoverTree_rightleft(TreeNode root, int[] post, TreeNode[] rightWrong) {
    if (rightWrong[0] == null && root != null) {
      recoverTree_rightleft(root.right, post, rightWrong);
      if (rightWrong[0] == null) {
        if (!(root.val <= post[0])) {
          rightWrong[0] = rightWrong[1];
          return;
        } else {
          post[0] = root.val;
          rightWrong[1] = root;
        }
        recoverTree_rightleft(root.left, post, rightWrong);
      }
    }
  }

  public void recoverTree(TreeNode root) {
    TreeNode[] leftWrong = new TreeNode[2];
    leftWrong[0] = null;
    recoverTree_leftright(root, new int[] {Integer.MIN_VALUE}, leftWrong);

    TreeNode[] rightWrong = new TreeNode[2];
    rightWrong[0] = null;
    recoverTree_rightleft(root, new int[] {Integer.MAX_VALUE}, rightWrong);

    int tmp = leftWrong[0].val;
    leftWrong[0].val = rightWrong[0].val;
    rightWrong[0].val = tmp;
  }
}
