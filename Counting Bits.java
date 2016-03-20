public class Solution {
  public int[] countBits(int num) {
    int[] ret = new int[num + 1];
    if (0 <= num) {
      ret[0] = 0;
    }
    if (1 <= num) {
      ret[1] = 1;
    }
    int idx = 2;
    for (int i = 2;; i = i << 1) {
      for (int j = 0; j < i; j++) { // ƴ��λ1
        if (idx <= num) {
          ret[idx++] = ret[j] + 1;
        } else {
          return ret;
        }
      }
    }
  }
}
-----------------
public class Solution {
  public int[] countBits(int num) {
    int[] f = new int[num + 1];
    for (int i = 1; i <= num; i++)
      f[i] = f[i >> 1] + (i & 1); // ƴĩλ1
    return f;
  }
}
