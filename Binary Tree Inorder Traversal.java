public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while (p != null || !stack.isEmpty()) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      if (!stack.isEmpty()) {
        p = stack.pop();
        ret.add(p.val);
        p = p.right;
      }
    }
    return ret;
  }
}
