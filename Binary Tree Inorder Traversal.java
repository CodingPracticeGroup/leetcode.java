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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(root==null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp=root;
        TreeNode right;
        while(!stack.isEmpty()||temp!=null){
            while(temp!=null){
                stack.push(temp);
                temp=temp.left;
            } 
            temp=stack.pop();
            //self
            result.add(temp.val);
            //right
            temp=temp.right;
        }
        return result;
    }
}