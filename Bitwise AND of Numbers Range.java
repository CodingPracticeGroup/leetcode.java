public class Solution {
  public int rangeBitwiseAnd(int m, int n) {
    int i = 0;
    while (m != n) {
      m = m >>> 1;
      n = n >>> 1;
      i++;
    }
    return m << i;
  }
}
--------
public class Solution {
  public int rangeBitwiseAnd(int m, int n) {
    if (Integer.highestOneBit(m) != Integer.highestOneBit(n)) {
      return 0;
    }
    for (int i = 0; i < 32; i++) {
      if ((m >> i) == (n >> i)) {
        return (m >> i) << i;
      }
    }
    return 0;
  }
}
------
