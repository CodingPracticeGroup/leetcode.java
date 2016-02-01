public class Solution {
  public boolean isValidSerialization(String preorder) {
    String[] p = preorder.split(",");
    int idx = 0; // stack
    for (int i = 0; i < p.length; i++) {
      if (p[i].equals("#")) {
        idx--;
      } else {
        if (idx < 0) { // check
          return false;
        }
        p[idx++] = p[i];
      }
    }
    return idx == -1; // check
  }
}
