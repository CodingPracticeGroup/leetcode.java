import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public void flatten(TreeNode root) {
    if (root != null) {
      Deque<TreeNode> stack = new ArrayDeque<>();
      stack.push(root);
      TreeNode last = null;
      while (!stack.isEmpty()) {
        TreeNode tn = stack.pop();
        if (last != null) {
          last.right = tn;
          last.left = null;
        }
        if (tn.right != null) {
          stack.push(tn.right);
        }
        if (tn.left != null) {
          stack.push(tn.left);
        }
        last = tn;
      }
    }
  }
}
---------
public class Solution {
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    TreeNode last = null;
    while (!stack.isEmpty()) {
      TreeNode tn = stack.pop();

      if (last != null) {
        last.right = tn;
        last.left = null;
      }
      last = tn;

      if (tn.right != null) {
        stack.push(tn.right);
      }
      if (tn.left != null) {
        stack.push(tn.left);
      }
    }
    if (last != null) {
      last.left = null;
      last.right = null;
    }
  }
}
------------------
public class Solution {
  TreeNode preOrderFlatten(TreeNode root) {
    if (root == null)
      return null;

    TreeNode oldL = root.left;
    TreeNode oldR = root.right;
    root.left = null;
    root.right = null;

    TreeNode Lret = preOrderFlatten(oldL);
    TreeNode Rret = preOrderFlatten(oldR);

    if (Lret != null && Rret != null) {
      root.right = oldL;
      Lret.right = oldR;
      return Rret;
    } else if (Lret == null && Rret != null) {
      root.right = oldR;
      return Rret;
    } else if (Lret != null && Rret == null) {
      root.right = oldL;
      return Lret;
    } else { // if (Lret==null && Rret ==null) {
      return root;
    }
  }

  public void flatten(TreeNode root) {
    preOrderFlatten(root);
  }
}
