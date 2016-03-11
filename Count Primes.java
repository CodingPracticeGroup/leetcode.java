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
--------------
public class Solution {
  public int countPrimes(int n) {
    if (n < 2)
      return 0;
    boolean p[] = new boolean[n];
    Arrays.fill(p, true);
    p[0] = false;
    p[1] = false;
    for (int i = 2; i * i < n; i++) { // check factors
      if (p[i]) {
        for (int j = i * i; j < n; j += i) { // mark the rest
          p[j] = false;
        }
      }
    }
    int ret = 0;
    for (boolean b : p) {
      if (b) {
        ret++;
      }
    }
    return ret;
  }
}
