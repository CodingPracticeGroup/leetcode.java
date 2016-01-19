public class Solution {
  private int digit(int x, int pos) {
    for (int i = 0; i < pos; i++) { // right shift
      x /= 10;
    }
    return x % 10; // cut the last digit
  }

  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    } else if (x < 10) {
      return true;
    }

    int len = 0;
    for (int i = x; i > 0; i /= 10) {
      len++;
    }

    int head = len - 1;
    int tail = 0;
    while (head > tail) {
      if (digit(x, head) != digit(x, tail)) {
        return false;
      }
      head--;
      tail++;
    }
    return true;
  }
}
