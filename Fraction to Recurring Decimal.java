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
----------------
public class Solution {
  private boolean check(List<Long> seen, long n) {
    return seen.stream().filter(x -> x == n).count() == 0;
  }

  public String fractionToDecimal(int numerator, int denominator) {
    long n = Math.abs((long) numerator);
    long d = Math.abs((long) denominator);
    StringBuilder sb = new StringBuilder(String.valueOf(n / d));
    if (numerator < 0 && denominator > 0)
      sb.insert(0, "-");
    if (numerator > 0 && denominator < 0)
      sb.insert(0, "-");
    if (numerator % denominator == 0) {
      return sb.toString();
    }
    sb.append('.');

    n = n % d;
    List<Long> seen = new ArrayList<>();
    while (n != 0 && check(seen, n)) {
      seen.add(n);
      sb.append(n * 10 / d);
      n = (n * 10) % d;
    }

    if (n == 0)
      return sb.toString();

    int idx = sb.length() - 1;
    for (int i = seen.size() - 1; i >= 0; i--) {
      if (seen.get(i) == n) {
        break;
      }
      idx--;
    }
    sb.insert(idx, "(");
    sb.append(')');

    return sb.toString();
  }
}
