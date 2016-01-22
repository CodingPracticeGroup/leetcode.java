public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    Deque<TreeNode> stack = new LinkedList<>();
    for (TreeNode p = root; p != null; p = p.left) {
      stack.push(p);
    }
    List<Integer> ret = new ArrayList<>();
    while (!stack.isEmpty()) {
      TreeNode tn = stack.pop();
      ret.add(tn.val);
      for (TreeNode p = tn.right; p != null; p = p.left) {
        stack.push(p);
      }
    }
    return ret;
  }

  public List<Integer> inorderTraversal_(TreeNode root) {
    List<Integer> ret = new ArrayList<>();

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while (!stack.isEmpty() || p != null) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      p = stack.pop();
      ret.add(p.val);
      p = p.right;
    }

    return ret;
  }
}
