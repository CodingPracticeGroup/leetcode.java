public class Solution {
  public String intToRoman(int num) {
    String[] roman =
        new String[] {"MMM", "MM", "M", "CM", "DCCC", "DCC", "DC", "D", "CD", "CCC", "CC", "C",
            "XC", "LXXX", "LXX", "LX", "L", "XL", "XXX", "XX", "X", "IX", "VIII", "VII", "VI", "V",
            "IV", "III", "II", "I"};
    int[] integer =
        new int[] {3000, 2000, 1000, 900, 800, 700, 600, 500, 400, 300, 200, 100, 90, 80, 70, 60,
            50, 40, 30, 20, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    StringBuilder sb = new StringBuilder();
    while (num > 0) {
      for (int i = 0; i < integer.length; i++) {
        if (num >= integer[i]) {
          num -= integer[i];
          sb.append(roman[i]);
        }
      }
    }
    return sb.toString();
  }
}
