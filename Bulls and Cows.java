public class Solution {
  public String getHint(String secret, String guess) {
    int s[] = new int[10];
    Arrays.fill(s, 0);
    int g[] = new int[10];
    Arrays.fill(g, 0);
    int len = secret.length();
    int A = 0;
    for (int i = 0; i < len; i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        A++;
      } else {
        s[secret.charAt(i) - '0']++;
        g[guess.charAt(i) - '0']++;
      }
    }
    int B = 0;
    for (int i = 0; i <= 9; i++) {
      B += Math.min(s[i], g[i]);
    }
    return A + "A" + B + "B";
  }
}
