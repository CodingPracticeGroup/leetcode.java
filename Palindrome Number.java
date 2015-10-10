public class Solution {
  private int isPalindrome_digit(int x, int position) {
    int pow = 1;
    for (int i = 1; i < position; i++) {
      pow *= 10;
    }
    x /= pow;
    return x % 10;
  }

  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    } else if (x < 10) {
      return true;
    }

    int t = x;
    int len = 0;
    while (t > 0) {
      t /= 10;
      len++;
    }

    for (int i = 1, j = len; i < j; i++, j--) {
      if (isPalindrome_digit(x, i) != isPalindrome_digit(x, j)) {
        return false;
      }
    }
    return true;
  }
}
