public class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ret = new LinkedList<>();
    if (root == null)
      return ret;
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root); // cannot process when push: non-order
    while (!stack.isEmpty()) {
      TreeNode tn = stack.pop();
      ret.add(0, tn.val); // process when pop: can only handle pre-order
      if (tn.left != null) {
        stack.push(tn.left); // cannot process when push: non-order
      }
      if (tn.right != null) {
        stack.push(tn.right); // cannot process when push: non-order
      }
    }
    return ret;
  }
}
----------------
public class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> ret = new LinkedList<>();

    Deque<TreeNode> stack = new ArrayDeque<>();

    for (TreeNode tn = root; tn != null; tn = tn.right) { // 起始
      ret.offerFirst(tn.val);
      stack.push(tn);
    }

    while (!stack.isEmpty()) { // 条件
      TreeNode node = stack.pop(); // if process here, it is in-order

      for (TreeNode tn = node.left; tn != null; tn = tn.right) { // 增量
        ret.offerFirst(tn.val);
        stack.push(tn);
      }
    }

    return ret;
  }
}
---------------
public class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> ret = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (!stack.isEmpty() || root != null) {
      if (root != null) { // stack push
        ret.offerFirst(root.val); // pre-order
        stack.push(root);
        root = root.right; // right first
      } else { // stack pop and try next layer
        root = stack.pop();
        root = root.left;
      }
    }
    return ret;
  }
}
-------------------
public class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> ret = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    for (TreeNode tn = root; tn != null; tn = tn.right) {
      stack.push(tn);
      ret.offerFirst(tn.val);
    }
    while (!stack.isEmpty()) {
      TreeNode tn = stack.pop();
      for (TreeNode tn2 = tn.left; tn2 != null; tn2 = tn2.right) {
        stack.push(tn2);
        ret.offerFirst(tn2.val);
      }
    }
    return ret;
  }
}
