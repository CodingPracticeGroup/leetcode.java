/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left; TreeNode right;
 * TreeNode(int x) { val = x; } }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[] flag=new boolean[1];
        isB(root,flag);
        return flag[0];
    }
    
    public int isB(TreeNode node, boolean[] flag){
        if(node==null){
            flag[0]=true;
            return 0;
        }
        boolean[] f1=new boolean[1];
        int h1=isB(node.left,f1);
        boolean[] f2=new boolean[1];
        int h2=isB(node.right,f2);
        if(f1[0]&&f2[0]){
            flag[0]=(Math.abs(h1-h2)<=1);
        }else flag[0]=false;
        
        return 1+Math.max(h1,h2);
    }
}
