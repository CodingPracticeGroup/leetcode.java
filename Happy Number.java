public class Solution {
  public boolean isHappy(int n) {
    Set<Integer> tabu = new HashSet<>();
    while (!tabu.contains(n)) {
      if (n == 1) {
        return true;
      }
      tabu.add(n);
      n = String.valueOf(n).chars().map(x -> x - '0').reduce(0, (acc, e) -> acc + e * e);
    }
    return false;
  }
}
