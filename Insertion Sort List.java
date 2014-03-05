/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        ListNode pointer1=head.next;
        ListNode pointer2;
        while(pointer1!=null){
            int temp=pointer1.val;
            pointer2=head;
            while(pointer2!=pointer1){
                if(temp<pointer2.val){
                    int swap = pointer2.val;
                    pointer2.val=temp;
                    temp=swap;
                }
                pointer2=pointer2.next;
            }
            pointer1.val=temp;
            pointer1=pointer1.next;
        }
        return head;
    }
}
