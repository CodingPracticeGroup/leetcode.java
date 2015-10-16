public class Solution {
  public String addBinary(String a, String b) {
    int[] a_ = new StringBuilder(a).reverse().toString().chars().map(i -> i - '0').toArray();
    int[] b_ = new StringBuilder(b).reverse().toString().chars().map(i -> i - '0').toArray();
    int[] long_ = a_;
    int[] short_ = b_;
    if (a_.length < b_.length) {
      long_ = b_;
      short_ = a_;
    }
    int carry = 0;
    for (int i = 0; i < short_.length; i++) {
      int tmp = short_[i] + long_[i] + carry;
      carry = tmp / 2;
      long_[i] = tmp % 2;
    }
    for (int i = short_.length; i < long_.length; i++) {
      int tmp = long_[i] + carry;
      carry = tmp / 2;
      long_[i] = tmp % 2;
    }
    StringBuilder sb = new StringBuilder();
    for (Integer i : long_) {
      sb.append(i);
    }
    String ret = sb.reverse().toString();
    if (carry > 0) {
      return "1" + ret;
    } else {
      return ret;
    }
  }
}
