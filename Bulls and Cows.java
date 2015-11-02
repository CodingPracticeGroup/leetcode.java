public class Solution {
  public String getHint(String secret, String guess) {
    int[] bull = new int[10];
    Arrays.fill(bull, 0);
    int[] cow = new int[10];
    Arrays.fill(cow, 0);
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        bull[secret.charAt(i) - '0']++;
      } else {
        cow[secret.charAt(i) - '0']++;
      }
    }
    int b = 0;
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) != guess.charAt(i)) {
        if (cow[guess.charAt(i) - '0'] > 0) {
          cow[guess.charAt(i) - '0']--;
          b++;
        }
      }
    }
    int a = 0;
    for (int i : bull) {
      if (i > 0)
        a += i;
    }
    return a + "A" + b + "B";
  }
}
