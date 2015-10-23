public class Solution {
  public int titleToNumber(String s) {
    int[] arr = s.chars().map(x -> x - 'A' + 1).toArray();
    // ..+a2x^2+a1x^1+a0x^0, ai=[1,26] x=[26]
    int ret = 0;
    for (int i = arr.length - 1; i >= 0; i--) {
      ret += Math.pow(26, arr.length - 1 - i) * arr[i];
    }
    return ret;
  }
}
