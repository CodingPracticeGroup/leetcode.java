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
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = root;
        while(temp!=null || !stack.empty()){
            if(temp.right!=null){stack.push(temp.right);}
            if(temp.left!=null){
                temp.right=temp.left;
                temp.left=null;
            }else if(!stack.empty()){
                temp.right=stack.pop();
            }
            temp=temp.right;
        }
    }
}
