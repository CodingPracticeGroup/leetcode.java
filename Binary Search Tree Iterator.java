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
    for (TreeNode p = tn.right; p != null; p = p.left)
      stack.push(p);
    return tn.val;
  }
}

public class BSTIterator {

  Deque<TreeNode> stack = new ArrayDeque<>();

  public BSTIterator(TreeNode root) {
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode p = stack.pop();

    TreeNode q = p.right;
    while (q != null) {
      stack.push(q);
      q = q.left;
    }

    return p.val;
  }
}
