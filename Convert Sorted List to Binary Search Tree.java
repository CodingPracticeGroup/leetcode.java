public class Solution {
  private TreeNode sortedListToBST_range(List<TreeNode> arr, int start, int end) {
    if (start == end)
      return null;
    int rootidx = (start + end) / 2;
    arr.get(rootidx).left = sortedListToBST_range(arr, start, rootidx);
    arr.get(rootidx).right = sortedListToBST_range(arr, rootidx + 1, end);
    return arr.get(rootidx);
  }

  public TreeNode sortedListToBST(ListNode head) {
    List<TreeNode> arr = new ArrayList<>(); // 这个不错，因为最终还是要创这么多的TreeNode
    while (head != null) {
      TreeNode tn = new TreeNode(head.val);
      arr.add(tn);
      head = head.next;
    }
    return sortedListToBST_range(arr, 0, arr.size());
  }
}
-------------
public class Solution {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return new TreeNode(head.val);
    }
    ListNode s1 = head;
    ListNode s2 = head.next;
    while (s2 != null && s2.next != null) {
      if (s2.next.next == null) {
        break;
      }
      s1 = s1.next;
      s2 = s2.next.next;
    }
    ListNode root = s1.next;
    s1.next = null;
    s2 = root.next;
    root.next = null;
    TreeNode ret = new TreeNode(root.val);
    ret.left = sortedListToBST(head);
    ret.right = sortedListToBST(s2);
    return ret;
  }
}
-----------------------
public class Solution {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null)
      return null;
    if (head.next == null)
      return new TreeNode(head.val);

    ListNode first = head;
    ListNode second = head.next;
    while (second != null && second.next != null && second.next.next != null) {
      first = first.next;
      second = second.next.next;
    }

    ListNode root = first.next;
    first.next = null;
    first = root.next;
    root.next = null;

    TreeNode ret = new TreeNode(root.val);
    ret.left = sortedListToBST(head);
    ret.right = sortedListToBST(first);
    return ret;
  }
}
