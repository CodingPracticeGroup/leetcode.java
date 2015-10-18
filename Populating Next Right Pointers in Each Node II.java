public class Solution {
  private TreeLinkNode connect_level(TreeLinkNode root) {
    TreeLinkNode first = null;
    TreeLinkNode last = null;
    while (root != null) {
      if (root.left != null) {
        if (first == null) {
          first = root.left;
        }
        if (last != null) {
          last.next = root.left;
        }
        last = root.left;
      }
      if (root.right != null) {
        if (first == null) {
          first = root.right;
        }
        if (last != null) {
          last.next = root.right;
        }
        last = root.right;
      }
      root = root.next;
    }
    return first;
  }

  public void connect(TreeLinkNode root) {
    for (TreeLinkNode last = root; last != null; last = connect_level(last)) {
    }
  }
}
