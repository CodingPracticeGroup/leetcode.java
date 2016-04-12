public class Solution {
  public boolean isHappy(int n) {
    Set<Integer> tabu = new HashSet<>();
    while (n != 1 && !tabu.contains(n)) {
      tabu.add(n);
      n = String.valueOf(n).chars().map(x -> x - '0').map(x -> x * x).reduce(0,
          (acc, e) -> acc + e);
    }
    if (n == 1) {
      return true;
    } else {
      return false;
    }
  }
}
-------------
public class Solution {
  public boolean isHappy(int n) {
    Set<Integer> s = new HashSet<>();
    while (n != 1) {
      if (!s.add(n))
        return false;
      int sum = 0;
      for (int i : String.valueOf(n).toCharArray()) {
        i -= '0';
        sum += i * i;
      }
      n = sum;
    }
    return true;
  }
}
