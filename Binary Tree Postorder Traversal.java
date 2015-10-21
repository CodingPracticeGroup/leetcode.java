public class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ret = new LinkedList<>();
    if (root == null)
      return ret;
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode tn = stack.pop();
      ret.add(0, tn.val);
      if (tn.left != null) {
        stack.push(tn.left);
      }
      if (tn.right != null) {
        stack.push(tn.right);
      }
    }
    return ret;
  }
}
