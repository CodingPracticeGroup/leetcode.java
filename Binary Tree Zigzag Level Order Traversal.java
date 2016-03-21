public class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root != null) {
      Deque<TreeNode> queue = new ArrayDeque<>();
      queue.offerLast(root);
      int level = 1;
      while (!queue.isEmpty()) {
        List<Integer> row = new ArrayList<>();
        int count = queue.size();
        for (int i = 0; i < count; i++) {
          TreeNode tn = queue.poll();
          row.add(tn.val);
          if (tn.left != null) {
            queue.offer(tn.left);
          }
          if (tn.right != null) {
            queue.offer(tn.right);
          }
        }
        if (level % 2 == 1) {
          ret.add(row);
        } else {
          Collections.reverse(row);
          ret.add(row);
        }
        level++;
      }
    }
    return ret;
  }
}
-----------
public class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }
    Deque<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    boolean reverse = false;
    while (!q.isEmpty()) {
      LinkedList<Integer> l = new LinkedList<>();
      int count = q.size();
      for (int i = 0; i < count; i++) {
        TreeNode tn = q.poll();
        l.add(tn.val);
        if (tn.left != null) {
          q.offer(tn.left);
        }
        if (tn.right != null) {
          q.offer(tn.right);
        }
      }
      if (reverse) {
        Collections.reverse(l);
      }
      reverse = !reverse;
      ret.add(l);
    }
    return ret;
  }
}
-------------------
public class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root == null)
      return ret;
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    boolean order = true;
    while (!queue.isEmpty()) {
      LinkedList<Integer> list = new LinkedList<>();
      int count = queue.size();
      for (int i = 0; i < count; i++) {
        TreeNode tn = queue.poll();
        if (order) {
          list.offerLast(tn.val);
        } else {
          list.offerFirst(tn.val);
        }
        if (tn.left != null) {
          queue.offer(tn.left);
        }
        if (tn.right != null) {
          queue.offer(tn.right);
        }
      }
      order = !order;
      ret.add(list);
    }
    return ret;
  }
}
