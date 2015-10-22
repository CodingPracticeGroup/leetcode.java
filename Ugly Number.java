public class Solution {
  public boolean isUgly(int num) {
    if (num == 1)
      return true;
    if (num <= 0)
      return false;
    while (num % 5 == 0) {
      num /= 5;
    }
    while (num % 2 == 0) {
      num /= 2;
    }
    while (num % 3 == 0) {
      num /= 3;
    }
    if (num != 1)
      return false;
    else
      return true;
  }
}
