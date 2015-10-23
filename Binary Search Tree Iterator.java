public class BSTIterator {
  Deque<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new ArrayDeque<>();
    for (TreeNode p = root; p != null; p = p.left)
      stack.push(p);
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode tn = stack.pop();
    int ret = tn.val;
    for (TreeNode p = tn.right; p != null; p = p.left)
      stack.push(p);
    return ret;
  }
}
