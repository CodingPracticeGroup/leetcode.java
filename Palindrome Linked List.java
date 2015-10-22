public class Solution {
  public boolean isPalindrome(ListNode head) {
    int count = 0;
    for (ListNode p = head; p != null; p = p.next)
      count++;
    if (count <= 1)
      return true;

    ListNode q = head;
    for (int i = 0; i < (count - 1) / 2; i++)
      q = q.next;

    ListNode myHead2 = new ListNode(0);
    while (q.next != null) {
      ListNode p = q.next;
      q.next = q.next.next;
      p.next = myHead2.next;
      myHead2.next = p;
    }

    ListNode p = myHead2.next;
    q = head;
    while (p != null && q != null) {
      if (p.val != q.val)
        return false;
      p = p.next;
      q = q.next;
    }
    return true;
  }
}
