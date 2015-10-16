public class Solution {
  public int[] plusOne(int[] digits) {
    List<Integer> l = Arrays.stream(digits).boxed().collect(Collectors.toList());
    Collections.reverse(l);
    int carry = 1;
    for (int i = 0; i < digits.length; i++) {
      int tmp = l.get(i) + carry;
      carry = tmp / 10;
      l.set(i, tmp % 10);
    }
    if (carry > 0) {
      l.add(carry);
    }
    Collections.reverse(l);
    return l.stream().mapToInt(i -> i).toArray();
  }
}
