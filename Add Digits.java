public class Solution {
  public int addDigits(int num) {
    while (num > 9) {
      num = String.valueOf(num).chars().map(x -> x - '0').reduce((x, y) -> x + y).getAsInt();
    }
    return num;
  }
}
