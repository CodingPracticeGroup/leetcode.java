public class Solution {
  int perfect(TreeNode root) {
    int c_l = 0;
    for (TreeNode tn = root; tn.left != null; tn = tn.left) {
      c_l++;
    }
    int c_r = 0;
    for (TreeNode tn = root; tn.right != null; tn = tn.right) {
      c_r++;
    }
    if (c_l == c_r) {
      return c_l;
    } else {
      return -1;
    }
  }

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int h = perfect(root);
    if (h >= 0) {
      return (1 << (h + 1)) - 1; // Math.pow timeout
    } else {
      return countNodes(root.left) + countNodes(root.right) + 1;
    }
  }
}
-------------
public class Solution {
  private int cn(TreeNode root, int leftHeight, int rightHeight) {
    if (root == null) {
      return 0;
    }
    if (leftHeight == -1) {
      for (TreeNode l = root; l != null; l = l.left) {
        leftHeight++;
      }
    }
    if (rightHeight == -1) {
      for (TreeNode l = root; l != null; l = l.right) {
        rightHeight++;
      }
    }
    if (leftHeight == rightHeight) {
      return (1 << (rightHeight + 1)) - 1; // Math.pow long time
    } else {
      return 1 + cn(root.left, leftHeight - 1, -1) + cn(root.right, -1, rightHeight - 1);
    }
  }

  public int countNodes(TreeNode root) {
    return cn(root, -1, -1);
  }
}
--------------
public class Solution {
  int cn(TreeNode root, int left, int right) { // left, right from parent, is not the key
    if (root == null)
      return 0;
    if (left < 0) {
      left = 0;
      for (TreeNode tn = root; tn != null; tn = tn.left) {
        left++;
      }
    }
    if (right < 0) {
      right = 0;
      for (TreeNode tn = root; tn != null; tn = tn.right) {
        right++;
      }
    }
    if (left == right) {
      return (1 << left) - 1; // key
    } else {
      return 1 + cn(root.left, left - 1, -1) + cn(root.right, -1, right - 1);
    }
  }

  public int countNodes(TreeNode root) {
    return cn(root, -1, -1);
  }
}
