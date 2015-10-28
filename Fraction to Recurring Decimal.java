public class Solution {
  public String fractionToDecimal(int numerator_, int denominator_) {
    long numerator, denominator;
    boolean negative = false;
    if ((numerator_ < 0 && denominator_ > 0) || (numerator_ > 0 && denominator_ < 0)) {
      negative = true;
    }
    numerator = Math.abs((long) numerator_);
    denominator = Math.abs((long) denominator_);
    StringBuilder sb = new StringBuilder();
    sb.append(numerator / denominator);
    if (numerator % denominator == 0) {
      return (negative ? "-" : "") + sb.toString();
    } else {
      sb.append('.');
    }
    numerator %= denominator;
    StringBuilder sb2 = new StringBuilder();
    List<Long> seen = new ArrayList<>();
    while (!(numerator == 0 || seen.indexOf(numerator) >= 0)) {
      seen.add(numerator);
      numerator *= 10;
      sb2.append(numerator / denominator);
      numerator %= denominator;
    }
    if (numerator != 0) {
      sb2.insert(seen.indexOf(numerator), "(");
      sb2.append(')');
    }
    return (negative ? "-" : "") + sb.toString() + sb2.toString();
  }
}
