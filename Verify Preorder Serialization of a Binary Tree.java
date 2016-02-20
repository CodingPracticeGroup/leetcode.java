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
--------------
public class Solution {
  public boolean isValidSerialization(String preorder) {
    String[] strs = preorder.split(","); // stack
    int idx = 0;
    for (int i = 0; i < strs.length; i++) {
      if (strs[i].equals("#")) { // pop
        idx--;
      } else {
        if (idx < 0) // check
          return false;
        strs[idx] = strs[i]; // push
        idx++;
      }
    }
    return idx == -1;
  }
}
