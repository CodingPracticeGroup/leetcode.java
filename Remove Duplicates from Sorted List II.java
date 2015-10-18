public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode myHead = new ListNode(0);
    myHead.next = head;
    ListNode p = myHead; // delete p.next
    while (p != null) {
      if (p.next != null && p.next.next != null && p.next.val == p.next.next.val) {
        int target = p.next.val;
        ListNode q = p;
        while (q.next != null && q.next.val == target) {
          q = q.next;
        }
        p.next = q.next;
      } else {
        p = p.next;
      }
    }
    return myHead.next;
  }
}
