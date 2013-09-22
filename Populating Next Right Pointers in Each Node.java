/**
 * Definition for binary tree with next pointer. public class TreeLinkNode { int val; TreeLinkNode
 * left, right, next; TreeLinkNode(int x) { val = x; } }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeLinkNode temp;
        if(root==null) return;
        root.next=null;
        while(root.left!=null){
            temp=root;
            do{
            temp.left.next=temp.right;
            if(null!=temp.right&&temp.next!=null){
                temp.right.next=temp.next.left;
            }
            temp=temp.next;
            }while(temp!=null);
            root=root.left;
        }
    }
}
