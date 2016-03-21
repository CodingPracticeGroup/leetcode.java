public class Solution {
  private void binaryTreePaths_bt(TreeNode root, List<String> ret, Deque<TreeNode> stack) {
    stack.offerLast(root);
    if (root.left == null && root.right == null) { // report
      StringBuilder sb = new StringBuilder();
      for (TreeNode tn : stack) {
        sb.append(tn.val);
        sb.append("->");
      }
      sb.setLength(sb.length() - 2);
      ret.add(sb.toString());
    } else {
      if (root.left != null) {
        binaryTreePaths_bt(root.left, ret, stack);
      }
      if (root.right != null) {
        binaryTreePaths_bt(root.right, ret, stack);
      }
    }
    stack.pollLast();
  }

  public List<String> binaryTreePaths_(TreeNode root) {
    List<String> ret = new ArrayList<>();
    if (root == null)
      return ret;
    binaryTreePaths_bt(root, ret, new ArrayDeque<TreeNode>());
    return ret;
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }
    if (root.left == null && root.right == null) {
      ret.add(String.valueOf(root.val));
      return ret;
    }
    if (root.left != null) {
      List<String> left = binaryTreePaths(root.left);
      for (String s : left) { // process after pop，构造法
        ret.add(root.val + "->" + s);
      }
    }
    if (root.right != null) {
      List<String> right = binaryTreePaths(root.right);
      for (String s : right) {
        ret.add(root.val + "->" + s);
      }
    }
    return ret;
  }
}
-----------------
public class Solution {
  void btp(TreeNode root, LinkedList<TreeNode> stack, List<String> ret) {
    if (root != null) {
      stack.offerLast(root);
      if (root.left == null && root.right == null) {
        StringBuilder sb = new StringBuilder();
        for (TreeNode tn : stack) {
          sb.append(tn.val + "->");
        }
        sb.setLength(sb.length() - 2);
        ret.add(sb.toString());
      }
      btp(root.left, stack, ret);
      btp(root.right, stack, ret);
      stack.pollLast();
    }
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> ret = new ArrayList<>();
    btp(root, new LinkedList<TreeNode>(), ret);
    return ret;
  }
}
