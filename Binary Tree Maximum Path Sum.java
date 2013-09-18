/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int sum;
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        sum=Integer.MIN_VALUE;
        maxps(root);
        return sum;
    }
    public int maxps(TreeNode root){
        if(root==null) return 0;
        int l=Math.max(0,maxps(root.left));
        int r=Math.max(0,maxps(root.right));
        if(l+r+root.val>sum) sum=l+r+root.val;
        return Math.max(l+root.val, r+root.val);
    }
}