public class Solution {
  public int countPrimes(int n) {
    if (n <= 2)
      return 0;
    boolean p[] = new boolean[n];
    Arrays.fill(p, true);
    for (int i = 4; i < n; i += 2) { // remove all 2's
      p[i] = false;
    }
    int nsqrt = (int) Math.sqrt(n); // only to sqrt
    for (int i = 3; i <= nsqrt; i += 2) {
      for (int j = i * i; j < n; j += i) { // start from i*i
        p[j] = false;
      }
    }
    int ret = 0;
    for (int i = 2; i < n; i++) {
      if (p[i]) {
        ret++;
      }
    }
    return ret;
  }

  public int countPrimes_(int n) {
    if (n <= 2) {
      return 0;
    }
    boolean dp[] = new boolean[n];
    Arrays.fill(dp, true);
    dp[0] = false;
    dp[1] = false;
    int termination = (int) Math.sqrt(n);
    for (int i = 2; i <= termination; i++) {
      if (dp[i]) {
        for (int j = i + i; j < n; j += i) {
          dp[j] = false;
        }
      }
    }
    int ret = 0;
    for (boolean b : dp) {
      if (b) {
        ret++;
      }
    }
    return ret;
  }
}
