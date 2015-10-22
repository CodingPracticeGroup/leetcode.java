public class Solution {
  private String binaryTreePaths_string(Deque<TreeNode> stack) {
    StringBuilder sb = new StringBuilder();
    for (TreeNode tn : stack) {
      if (sb.length() > 0) {
        sb.append("->");
      }
      sb.append(tn.val);
    }
    return sb.toString();
  }

  private void binaryTreePaths_(TreeNode root, List<String> ret, Deque<TreeNode> stack) {
    if (root != null) {
      stack.offerLast(root);
      if (root.left == null && root.right == null) {
        ret.add(binaryTreePaths_string(stack));
      } else {
        binaryTreePaths_(root.left, ret, stack);
        binaryTreePaths_(root.right, ret, stack);
      }
      stack.pollLast();
    }
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> ret = new LinkedList<>();
    binaryTreePaths_(root, ret, new LinkedList<TreeNode>());
    return ret;
  }
}
