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
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head==null) return null;
        RandomListNode temp=head;
        RandomListNode newnode;
        RandomListNode newhead=new RandomListNode(head.label);
        temp=temp.next;
        newhead.next=head.next;
        head.next=newhead;
        
        while(temp!=null){
            newnode=new RandomListNode(temp.label);
            newnode.next=temp.next;
            temp.next=newnode;
            temp=temp.next.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.random!=null) temp.next.random=temp.random.next;
            else temp.next.random=null;
            temp=temp.next.next;
        }
        
        temp=head;
        RandomListNode newtemp=newhead;
        while(temp!=null&&newtemp!=null){
            temp.next=temp.next.next;
            if(newtemp.next!=null) newtemp.next=newtemp.next.next;
            else newtemp.next=null;
            temp=temp.next;
            newtemp=newtemp.next;
        }
        
        return newhead;
    }
}