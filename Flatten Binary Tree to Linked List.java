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
