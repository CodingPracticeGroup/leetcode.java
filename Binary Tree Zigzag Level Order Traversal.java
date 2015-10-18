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
