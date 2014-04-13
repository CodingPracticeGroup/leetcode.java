/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(null==head) return null;
        RandomListNode p = head;
        //insert new nodes
        while(p!=null){
            RandomListNode newnode = new RandomListNode(p.label);
            newnode.next=p.next;
            p.next=newnode;
            p=newnode.next;
        }
        //copy random nodes
        p=head;
        while(p!=null){
            p.next.random=p.random==null?null:p.random.next;
            p=p.next.next;
        }
        //split two lists
        RandomListNode newhead = head.next;
        RandomListNode newp = newhead;
        p=head;
        while(p!=null){
            p.next=newp.next;
            p=p.next;
            if(p!=null){
                newp.next=p.next;
                newp=newp.next;
            }
        }
        return newhead;
    }
}
