public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root != null) {
      Deque<TreeNode> queue = new ArrayDeque<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
        List<Integer> row = new ArrayList<>();
        int levelcount = queue.size();
        for (int i = 0; i < levelcount; i++) {
          TreeNode tn = queue.poll();
          if (tn.left != null) {
            queue.offer(tn.left);
          }
          if (tn.right != null) {
            queue.offer(tn.right);
          }
          row.add(tn.val);
        }
        ret.add(row);
      }
    }
    return ret;
  }
}
