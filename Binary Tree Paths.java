public class Solution {
  private void binaryTreePaths_bt(TreeNode root, List<String> ret, Deque<TreeNode> stack) {
    stack.offerLast(root);
    if (root.left == null && root.right == null) { // report
      StringBuilder sb = new StringBuilder();
      for (TreeNode tn : stack) {
        sb.append(tn.val);
        sb.append("->");
      }
      sb.setLength(sb.length() - 2);
      ret.add(sb.toString());
    } else {
      if (root.left != null) {
        binaryTreePaths_bt(root.left, ret, stack);
      }
      if (root.right != null) {
        binaryTreePaths_bt(root.right, ret, stack);
      }
    }
    stack.pollLast();
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> ret = new ArrayList<>();
    if (root == null)
      return ret;
    binaryTreePaths_bt(root, ret, new ArrayDeque<TreeNode>());
    return ret;
  }
}
