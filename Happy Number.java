public class Solution {
  public boolean isHappy(int n) {
    Set<Integer> seen = new HashSet<>();
    while (!seen.contains(n)) {
      seen.add(n);
      n = String.valueOf(n).chars().map(x -> x - '0').reduce(0, (acc, e) -> acc + e * e);
      if (n == 1) {
        return true;
      }
    }
    return false;
  }
}
