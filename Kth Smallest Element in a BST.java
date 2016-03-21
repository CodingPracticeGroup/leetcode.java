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
  
  //如果BST节点TreeNode的属性可以扩展，则再添加一个属性leftCnt，记录左子树的节点个数
}
-------------------------
public class Solution {
  public int kthSmallest(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    for (TreeNode tn = root; tn != null; tn = tn.left) {
      stack.push(tn);
    }
    while (!stack.isEmpty()) {
      TreeNode tn = stack.pop();
      if (--k == 0) {
        return tn.val;
      }
      for (TreeNode tn2 = tn.right; tn2 != null; tn2 = tn2.left) {
        stack.push(tn2);
      }
    }
    return 0; // You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
  }
}
