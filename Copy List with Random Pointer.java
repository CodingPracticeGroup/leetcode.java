public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null)
      return null;
    RandomListNode p = head;
    while (p != null) {
      RandomListNode q = new RandomListNode(p.label);
      q.next = p.next;
      p.next = q;
      p = q.next;
    }
    p = head;
    while (p != null) {
      RandomListNode q = p.random;
      if (q != null) {
        p.next.random = q.next;
      } else {
        p.next.random = null;
      }
      p = p.next.next;
    }
    RandomListNode ret = head.next;
    p = head;
    while (p != null) {
      RandomListNode q = p.next;
      p.next = q.next;
      if (p.next != null) {
        q.next = p.next.next;
      }
      p = p.next;
    }
    return ret;
  }
}
