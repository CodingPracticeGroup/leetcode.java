public class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode myHead1 = new ListNode(0);
    myHead1.next = head;
    ListNode myHead2 = new ListNode(0);
    while (myHead1.next != null) {
      ListNode p = myHead1.next;
      myHead1.next = p.next;
      p.next = myHead2.next;
      myHead2.next = p;
    }
    return myHead2.next;
  }
}
