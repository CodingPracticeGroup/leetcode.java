public class Solution {
  public int titleToNumber(String s) {
    List<Integer> l = s.chars().map(x -> x - 'A' + 1).boxed().collect(Collectors.toList());
    Collections.reverse(l);
    int[] arr = l.stream().mapToInt(x -> x).toArray();
    // ..+a2x^2+a1x^1+a0x^0, ai=[1,26] x=[26]
    int ret = 0;
    for (int i = 0; i < arr.length; i++) {
      ret += Math.pow(26, i) * arr[i];
    }
    return ret;
  }
}
