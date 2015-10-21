public class Solution {
  public void reorderList(ListNode head) {
    ListNode myHead = new ListNode(0);
    myHead.next = head;
    ListNode p1 = myHead;
    ListNode p2 = myHead;
    while (p1 != null && p2 != null && p2.next != null) {
      p1 = p1.next;
      p2 = p2.next.next;
    }

    ListNode myHead2 = new ListNode(0);
    while (p1.next != null) {
      p2 = p1.next;
      p1.next = p2.next;
      p2.next = myHead2.next;
      myHead2.next = p2;
    }

    p1 = myHead.next;
    while (myHead2.next != null) {
      p2 = myHead2.next;
      myHead2.next = p2.next;
      p2.next = p1.next;
      p1.next = p2;
      p1 = p1.next.next;
    }
  }
}
