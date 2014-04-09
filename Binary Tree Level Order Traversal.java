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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(null==root) return result; 
        ArrayList<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        while(!level.isEmpty()){
            ArrayList<TreeNode> nextlevel = new ArrayList<TreeNode>();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i=0;i<level.size();i++){
                TreeNode node = level.get(i);
                temp.add(node.val);
                if(node.left!=null)
                {
                    nextlevel.add(node.left);
                }
                if(node.right!=null)
                {
                    nextlevel.add(node.right);
                }
            }
            result.add(temp);
            level=nextlevel;
        }
        return result;
    }
}
