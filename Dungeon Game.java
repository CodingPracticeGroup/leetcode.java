public class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
    int M = dungeon.length;
    int N = dungeon[0].length;
    int dp[][] = new int[M][N];
    dp[M - 1][N - 1] = dungeon[M - 1][N - 1] > 0 ? 1 : 1 - dungeon[M - 1][N - 1];
    for (int i = N - 2; i >= 0; i--) {
      dp[M - 1][i] = Math.max(1, dp[M - 1][i + 1] - dungeon[M - 1][i]);
    }
    for (int i = M - 2; i >= 0; i--) {
      dp[i][N - 1] = Math.max(1, dp[i + 1][N - 1] - dungeon[i][N - 1]);
    }
    for (int i = M - 2; i >= 0; i--) {
      for (int j = N - 2; j >= 0; j--) {
        int x = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
        int y = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
        dp[i][j] = Math.min(x, y);
      }
    }
    return dp[0][0];
  }
}
-----------------
public class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
    int m = dungeon.length;
    int n = dungeon[0].length;
    int[][] dp = new int[m][n]; // hp when entering i,j
    if (dungeon[m - 1][n - 1] < 0) {
      dp[m - 1][n - 1] = 1 - dungeon[m - 1][n - 1];
    } else {
      dp[m - 1][n - 1] = 1;
    }
    for (int i = m - 2; i >= 0; i--) {
      if (dungeon[i][n - 1] < 0) {
        dp[i][n - 1] = dp[i + 1][n - 1] - dungeon[i][n - 1];
      } else {
        dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
      }
    }
    for (int j = n - 2; j >= 0; j--) {
      if (dungeon[m - 1][j] < 0) {
        dp[m - 1][j] = dp[m - 1][j + 1] - dungeon[m - 1][j];
      } else {
        dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
      }
    }

    for (int i = m - 2; i >= 0; i--) {
      for (int j = n - 2; j >= 0; j--) {
        if (dungeon[i][j] < 0) {
          dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
        } else {
          dp[i][j] = Math.min(Math.max(dp[i + 1][j] - dungeon[i][j], 1),
              Math.max(dp[i][j + 1] - dungeon[i][j], 1));
        }
      }
    }

    return dp[0][0];
  }
}
