public class Solution {
	public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(m==0||n==0) return 0;
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++){
            dp[i][0]=1;
            for(int j=1;j<n;j++){
                if(0==i) dp[0][j]=1;
                else
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}