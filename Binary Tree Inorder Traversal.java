public class Solution {
  private void inorderTraversal_preorder(TreeNode root, List<Integer> ret) {
    if (root != null) {
      inorderTraversal_preorder(root.left, ret);
      ret.add(root.val);
      inorderTraversal_preorder(root.right, ret);
    }
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    inorderTraversal_preorder(root, ret);
    return ret;
  }
}
