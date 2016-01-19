public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }
    Deque<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    while (!q.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int count = q.size();
      for (int i = 0; i < count; i++) {
        TreeNode tn = q.poll();
        level.add(tn.val);
        if (tn.left != null) {
          q.offer(tn.left);
        }
        if (tn.right != null) {
          q.offer(tn.right);
        }
      }
      ret.add(level);
    }
    return ret;
  }
}
