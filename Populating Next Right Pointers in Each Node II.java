/**
 * Definition for binary tree with next pointer.
 */ 
class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }

public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root!=null) {
            TreeLinkNode memory = root;
            while (memory.left!=null || memory.right!=null) {
                for (TreeLinkNode pointer = memory;pointer!=null;) {
                    if (pointer.left!=null && pointer.right!=null) {
                        pointer.left.next = pointer.right;
                    }
                    TreeLinkNode pointerNext = pointer.next;
                    while (pointerNext!=null && pointerNext.left==null && pointerNext.right==null) {
                        pointerNext = pointerNext.next;
                    }
                    if (pointerNext!=null) {
                        if (pointer.right==null) {
                            pointer.left.next = pointerNext.left!=null?pointerNext.left:pointerNext.right;
                        } else {
                            pointer.right.next = pointerNext.left!=null?pointerNext.left:pointerNext.right;
                        }
                    }
                    pointer=pointerNext;
                }
                //
                memory = memory.left!=null? memory.left: memory.right;
                while (memory.next!=null && memory.left==null && memory.right==null) {
                    memory = memory.next;
                }
            }
        }
    }
}