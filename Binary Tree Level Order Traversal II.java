public class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root != null) {
      Deque<TreeNode> queue = new ArrayDeque<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
        List<Integer> level = new ArrayList<>();
        int count = queue.size();
        for (int i = 0; i < count; i++) {
          TreeNode tn = queue.poll();
          level.add(tn.val);
          if (tn.left != null)
            queue.offer(tn.left);
          if (tn.right != null)
            queue.offer(tn.right);
        }
        ret.add(level);
      }
    }
    Collections.reverse(ret);
    return ret;
  }
}
