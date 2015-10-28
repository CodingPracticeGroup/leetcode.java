public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null)
      return null;
    StringBuilder sb = new StringBuilder();
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int count = queue.size();
      for (int i = 0; i < count; i++) {
        TreeNode tn = queue.poll();
        if (tn == null) {
          sb.append("null");
        } else {
          sb.append(tn.val);
        }
        sb.append(',');
        if (tn != null) {
          queue.offer(tn.left);
          queue.offer(tn.right);
        }
      }
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null)
      return null;
    String[] sarr = data.split(",");
    int count = 0;
    TreeNode root = new TreeNode(Integer.parseInt(sarr[count++]));
    Deque<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int level_count = q.size();
      for (int j = 0; j < level_count; j++) {
        TreeNode tn = q.poll();
        String left = null;
        if (count < sarr.length)
          left = sarr[count++].equals("null") ? null : sarr[count - 1];
        String right = null;
        if (count < sarr.length)
          right = sarr[count++].equals("null") ? null : sarr[count - 1];
        if (left != null) {
          tn.left = new TreeNode(Integer.parseInt(left));
          q.offer(tn.left);
        }
        if (right != null) {
          tn.right = new TreeNode(Integer.parseInt(right));
          q.offer(tn.right);
        }
      }
    }
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
