/**
 * Definition for binary tree
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(null==root) return false;
        if(sum==root.val&&root.left==null&&root.right==null) return true;
        return hasPathSum(root.left,sum-root.val)|| hasPathSum(root.right,sum-root.val);
    }
}
