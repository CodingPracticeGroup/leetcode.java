public class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    if (root == null)
      return ret;
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode tn = stack.pop();
      ret.add(tn.val);
      if (tn.right != null) {
        stack.push(tn.right);
      }
      if (tn.left != null) {
        stack.push(tn.left);
      }
    }
    return ret;
  }

  public List<Integer> preorderTraversal_(TreeNode root) {
    List<Integer> ret = new ArrayList<>();

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode current = root;
    while (!stack.isEmpty() || current != null) {
      while (current != null) {
        stack.push(current);
        ret.add(current.val);
        current = current.left;
      }
      current = stack.pop().right;
    }

    return ret;
  }
}
