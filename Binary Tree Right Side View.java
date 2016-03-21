public class Solution {
  private void rightSideView_(TreeNode root, List<Integer> ret, Deque<TreeNode> stack) {
    if (root != null) {
      stack.push(root);
      if (stack.size() > ret.size())
        ret.add(root.val);
      rightSideView_(root.right, ret, stack);
      rightSideView_(root.left, ret, stack);
      stack.pop();
    }
  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    rightSideView_(root, ret, new LinkedList<TreeNode>());
    return ret;
  }
}
------------------
public class Solution {
  private void r(TreeNode root, List<Integer> ret, Deque<TreeNode> stack) {
    if (root == null) {
      return;
    }
    stack.push(root);
    if (stack.size() > ret.size()) {
      ret.add(stack.peek().val);
    }
    r(root.right, ret, stack);
    r(root.left, ret, stack);
    stack.pop();
  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    r(root, ret, new ArrayDeque<TreeNode>());
    return ret;
  }
}
------------------------
public class Solution {
  void dfs(TreeNode root, List<Integer> ret, LinkedList<TreeNode> stack) {
    if (root != null) {
      stack.offerLast(root);
      if (stack.size() > ret.size()) {
        ret.add(root.val);
      }
      dfs(root.right, ret, stack);
      dfs(root.left, ret, stack);
      stack.pollLast();
    }
  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    dfs(root, ret, new LinkedList<TreeNode>());
    return ret;
  }
}
