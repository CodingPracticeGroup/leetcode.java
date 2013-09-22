/**
 * Definition for binary tree with next pointer. public class TreeLinkNode { int val; TreeLinkNode
 * left, right, next; TreeLinkNode(int x) { val = x; } }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return;
        root.next=null;
        TreeLinkNode first=root;
        TreeLinkNode firstcd=null;
        TreeLinkNode nextcd=null;
        TreeLinkNode temp;
        
        while(first!=null){
            temp=first;
            firstcd=null;
            //find first child
            while(temp!=null){
                if(temp.left!=null){
                    firstcd=temp.left; break;
                }
                if(temp.right!=null){
                    firstcd=temp.right; break;
                }
                temp=temp.next;
            }
            first=firstcd;
            
            while(firstcd!=null&&temp!=null){
                nextcd=null;
                while(temp!=null){
                    //find nextchild
                    if(firstcd==temp.right) {temp=temp.next;continue;}
                    if(temp.left!=null&&temp.left!=firstcd){
                        nextcd=temp.left; break;
                    }
                    if(temp.right!=null&&temp.right!=firstcd){
                        nextcd=temp.right; break;
                    }
                    temp=temp.next;
                }
                firstcd.next=nextcd;
                firstcd=nextcd;
            }
        }
        return;
    }
}
