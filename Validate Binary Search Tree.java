/**
 * Definition for binary tree
 */ 
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return recursion(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    // the recursion function declaration is different from the original one, so we need a new one
    private boolean recursion(TreeNode root, Integer min, Integer max) {
        if (root==null) {
            return true;
        }
        if (min>=root.val || root.val>=max) {
            return false;
        }
        return recursion(root.left, min, root.val) && recursion (root.right, root.val, max);
    }
}