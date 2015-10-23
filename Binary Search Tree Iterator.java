public class BSTIterator {

  private Deque<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new LinkedList<>();
    TreeNode p = root;
    while (p != null) {
      stack.push(p);
      p = p.left;
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode p = stack.pop();
    int ret = p.val;
    p = p.right;
    while (p != null) {
      stack.push(p);
      p = p.left;
    }
    return ret;
  }
}
