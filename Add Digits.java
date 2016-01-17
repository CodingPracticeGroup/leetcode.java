public class Solution {
  public int addDigits(int num) {
    return num - 9 * ((num - 1) / 9);
  }

  public int addDigits_(int num) {
    while (num > 9) {
      num = String.valueOf(num).chars().map(x -> x - '0').reduce(0, (a, b) -> a + b);
    }
    return num;
  }
}
