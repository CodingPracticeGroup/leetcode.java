public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode root=new ListNode(0);
        if(head==null||head.next==null) return head;
        root.next=head;
        ListNode start=head;
        ListNode temp=root;
        ListNode end=head;
        while(end!=null){
            while(end!=null&&end.val==start.val){
                end=end.next;
            }
            if(start.next!=end)
            {
                temp.next=end;
            }
            else{
                temp.next=start;temp=start;
            }
            start=end;
        }
        return root.next;
    }
}