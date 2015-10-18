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
    List<TreeNode> arr = new ArrayList<>();
    while (head != null) {
      TreeNode tn = new TreeNode(head.val);
      arr.add(tn);
      head = head.next;
    }
    return sortedListToBST_range(arr, 0, arr.size());
  }
}
