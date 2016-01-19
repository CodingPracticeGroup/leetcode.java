public class Solution {
  public int[] plusOne(int[] digits) {
    LinkedList<Integer> ret = new LinkedList<>();
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      int sum = digits[i] + carry;
      ret.offerFirst(sum % 10);
      carry = sum / 10;
    }
    if (carry > 0) {
      ret.offerFirst(carry);
    }
    return ret.stream().mapToInt(x -> x).toArray();
  }
}
