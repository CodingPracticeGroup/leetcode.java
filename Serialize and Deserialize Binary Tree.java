public class Codec {

  private void serialize_sb(TreeNode root, StringBuilder sb, int height) {
    if (sb.length() != 0) {
      sb.append(",");
    }
    sb.append(root.val + "#" + height);
  }

  private void serialize_(TreeNode root, StringBuilder sb, int height) {
    if (root != null) {
      serialize_(root.left, sb, height + 1);
      serialize_sb(root, sb, height);
      serialize_(root.right, sb, height + 1);
    }
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serialize_(root, sb, 0);
    return sb.toString();
  }

  private int deserialize_val(String s) {
    String ss[] = s.split("#");
    return Integer.parseInt(ss[0]);
  }

  private int deserialize_h(String s) {
    String ss[] = s.split("#");
    return Integer.parseInt(ss[1]);
  }

  private TreeNode deserialize_(String d[], int start, int end, int height) {
    if (start == end) {
      return null;
    } else if (start + 1 == end) {
      return new TreeNode(deserialize_val(d[start]));
    } else {
      int root = start;
      while (root < end && deserialize_h(d[root]) != height) {
        root++;
      }
      TreeNode ret = new TreeNode(deserialize_val(d[root]));
      ret.left = deserialize_(d, start, root, height + 1);
      ret.right = deserialize_(d, root + 1, end, height + 1);
      return ret;
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.length() == 0)
      return null;
    String d[] = data.split(",");
    return deserialize_(d, 0, d.length, 0);
  }
}
