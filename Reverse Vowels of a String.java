public class Solution {
  boolean isVowel(char c) {
    if (c == 'a' || c == 'A')
      return true;
    if (c == 'e' || c == 'E')
      return true;
    if (c == 'i' || c == 'I')
      return true;
    if (c == 'o' || c == 'O')
      return true;
    if (c == 'u' || c == 'U')
      return true;
    return false;
  }

  public String reverseVowels(String s) {
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    int i = 0;
    int j = s.length() - 1;
    while (i <= j) {
      while (i < j && !isVowel(s.charAt(i))) {
        sb1.append(s.charAt(i));
        i++;
      }
      while (i < j && !isVowel(s.charAt(j))) {
        sb2.append(s.charAt(j));
        j--;
      }
      if (i < j) {
        sb1.append(s.charAt(j));
        sb2.append(s.charAt(i));
        i++;
        j--;
      } else if (i == j) {
        sb1.append(s.charAt(i));
        i++;
      }
    }
    sb2.reverse();
    sb1.append(sb2);
    return sb1.toString();
  }
}
