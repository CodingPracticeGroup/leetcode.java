public class Solution {
  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    int aIdx = a.length() - 1;
    int bIdx = b.length() - 1;
    while (aIdx >= 0 || bIdx >= 0) {
      int sum = carry;
      if (aIdx >= 0) {
        sum += a.charAt(aIdx) - '0';
      }
      if (bIdx >= 0) {
        sum += b.charAt(bIdx) - '0';
      }

      sb.insert(0, sum % 2);
      carry = sum / 2;

      aIdx--;
      bIdx--;
    }
    if (carry > 0) {
      sb.insert(0, carry);
    }
    return sb.toString();
  }
}
