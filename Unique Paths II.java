public class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid[0][0] == 1) {
      return 0;
    } else {
      obstacleGrid[0][0] = -1;
    }
    for (int i = 1; i < obstacleGrid.length; i++) {
      if (obstacleGrid[i][0] != 1)
        obstacleGrid[i][0] = -1;
      else
        break;
    }
    for (int i = 1; i < obstacleGrid[0].length; i++) {
      if (obstacleGrid[0][i] != 1)
        obstacleGrid[0][i] = -1;
      else
        break;
    }
    for (int i = 1; i < obstacleGrid.length; i++) {
      for (int j = 1; j < obstacleGrid[0].length; j++) {
        if (obstacleGrid[i][j] != 1) {
          if (obstacleGrid[i - 1][j] != 1)
            obstacleGrid[i][j] += obstacleGrid[i - 1][j];
          if (obstacleGrid[i][j - 1] != 1)
            obstacleGrid[i][j] += obstacleGrid[i][j - 1];
        }
      }
    }
    if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] < 0)
      return -obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    else
      return 0;
  }
}
----------
public class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    if (m == 0) {
      return 0;
    }
    int n = obstacleGrid[0].length;
    if (n == 0) {
      return 0;
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (obstacleGrid[i][j] > 0) {
          obstacleGrid[i][j] *= -1;
        }
      }
    }
    //
    if (obstacleGrid[0][0] == 0) {
      obstacleGrid[0][0] = 1;
    }
    for (int i = 1; i < m; i++) {
      if (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] > 0) {
        obstacleGrid[i][0] = obstacleGrid[i - 1][0];
      }
    }
    for (int j = 1; j < n; j++) {
      if (obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] > 0) {
        obstacleGrid[0][j] = obstacleGrid[0][j - 1];
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] == 0) {
          obstacleGrid[i][j] = (obstacleGrid[i - 1][j] > 0 ? obstacleGrid[i - 1][j] : 0)
              + (obstacleGrid[i][j - 1] > 0 ? obstacleGrid[i][j - 1] : 0);
        }
      }
    }
    return obstacleGrid[m - 1][n - 1] > 0 ? obstacleGrid[m - 1][n - 1] : 0;
  }
}
--------------------
public class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int dp[] = new int[obstacleGrid[0].length];
    dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
    for (int i = 1; i < obstacleGrid[0].length; i++) {
      if (obstacleGrid[0][i] == 1) {
        dp[i] = 0;
      } else {
        dp[i] = dp[i - 1];
      }
    }
    for (int i = 1; i < obstacleGrid.length; i++) {
      dp[0] = obstacleGrid[i][0] == 1 ? 0 : dp[0];
      for (int j = 1; j < obstacleGrid[0].length; j++) {
        if (obstacleGrid[i][j] == 1) {
          dp[j] = 0;
        } else {
          dp[j] += dp[j - 1];
        }
      }
    }
    return dp[obstacleGrid[0].length - 1];
  }
}
