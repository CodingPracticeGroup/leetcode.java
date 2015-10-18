public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root != null) {
      Deque<TreeNode> queue = new ArrayDeque<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
        List<Integer> row = new ArrayList<>();
        Deque<TreeNode> nextLevel = new ArrayDeque<>();
        for (TreeNode tn : queue) {
          if (tn.left != null)
            nextLevel.offer(tn.left);
          if (tn.right != null)
            nextLevel.offer(tn.right);
          row.add(tn.val);
        }
        ret.add(row);
        queue = nextLevel;
      }
    }
    return ret;
  }
}
