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
-------------
public class Solution {
  public void connect(TreeLinkNode root) {
    TreeLinkNode currentLevel = root;
    while (currentLevel != null) {
      TreeLinkNode nextLevel = null;

      TreeLinkNode levelLast = null;
      for (TreeLinkNode tln = currentLevel; tln != null; tln = tln.next) {
        if (tln.left != null) {
          if (nextLevel == null) {
            nextLevel = tln.left;
          }
          if (levelLast != null) {
            levelLast.next = tln.left;
          }
          levelLast = tln.left;
        }
        if (tln.right != null) {
          if (nextLevel == null) {
            nextLevel = tln.right;
          }
          if (levelLast != null) {
            levelLast.next = tln.right;
          }
          levelLast = tln.right;
        }
      }

      currentLevel = nextLevel;
    }
  }
}
