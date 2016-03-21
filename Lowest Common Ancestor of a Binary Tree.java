public class Solution {
  private void lowestCommonAncestor_bt(TreeNode root, TreeNode p, List<TreeNode> ret,
      Deque<TreeNode> stack) {
    if (root != null) {
      stack.offerLast(root);
      if (root == p) {
        ret.addAll(stack);
      } else {
        if (ret.isEmpty())
          lowestCommonAncestor_bt(root.left, p, ret, stack);
        if (ret.isEmpty())
          lowestCommonAncestor_bt(root.right, p, ret, stack);
      }
      stack.pollLast();
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> pathp = new ArrayList<>();
    lowestCommonAncestor_bt(root, p, pathp, new ArrayDeque<TreeNode>());
    List<TreeNode> pathq = new ArrayList<>();
    lowestCommonAncestor_bt(root, q, pathq, new ArrayDeque<TreeNode>());
    int len = Math.min(pathp.size(), pathq.size());
    for (int i = 0; i < len; i++) {
      if (pathp.get(i) != pathq.get(i)) {
        return pathp.get(i - 1);
      }
    }
    if (len == pathp.size()) {
      return pathp.get(len - 1);
    } else {
      return pathq.get(len - 1);
    }
  }
}
-----------
public class Solution {
  private void path(TreeNode root, TreeNode p, TreeNode q, LinkedList<TreeNode> pp,
      LinkedList<TreeNode> qq, Deque<TreeNode> stack) {
    if (root == null) {
      return;
    }
    stack.offerLast(root);
    if (root == p) {
      pp.addAll(stack);
    }
    if (root == q) {
      qq.addAll(stack);
    }
    path(root.left, p, q, pp, qq, stack);
    path(root.right, p, q, pp, qq, stack);
    stack.pollLast();
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    LinkedList<TreeNode> pp = new LinkedList<>();
    LinkedList<TreeNode> qq = new LinkedList<>();
    path(root, p, q, pp, qq, new ArrayDeque<TreeNode>());
    TreeNode ret = null;
    while (pp.peekFirst() == qq.peekFirst()) {
      ret = pp.peekFirst();
      pp.pollFirst();
      qq.pollFirst();
    }
    return ret;
  }
}
------------------
public class Solution {
  LinkedList<TreeNode> lca(TreeNode root, TreeNode t) {
    if (root == null)
      return null;
    if (root == t) {
      LinkedList<TreeNode> ret = new LinkedList<>();
      ret.offerLast(t);
      return ret;
    }
    LinkedList<TreeNode> r = lca(root.left, t);
    if (r != null) {
      r.offerFirst(root);
      return r;
    }
    r = lca(root.right, t);
    if (r != null) {
      r.offerFirst(root);
      return r;
    }
    return null;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    LinkedList<TreeNode> pp = lca(root, p);
    LinkedList<TreeNode> qq = lca(root, q);
    TreeNode ret = root;
    while (!pp.isEmpty() && !qq.isEmpty() && pp.peekFirst() == qq.peekFirst()) {
      ret = pp.pollFirst();
      qq.pollFirst();
    }
    return ret;
  }
}
