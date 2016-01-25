public class Solution {
  public int kthSmallest(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while (!stack.isEmpty() || p != null) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      p = stack.pop();
      k--;
      if (k == 0) {
        return p.val;
      }
      p = p.right;
    }
    return 0;
  }

  public int kthSmallest_(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    for (TreeNode tn = root; tn != null; tn = tn.left) {
      stack.push(tn);
    }
    int count = 0;
    while (!stack.isEmpty()) {
      TreeNode tn2 = stack.pop();
      count++;
      if (count == k) {
        return tn2.val;
      }
      for (TreeNode tn = tn2.right; tn != null; tn = tn.left) {
        stack.push(tn);
      }
    }
    return -1;
  }
}
