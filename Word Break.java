public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(dict.contains(s.substring(i,j+1))){
                    dp[i][j]=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dp[0][i]==1){
                if(i==n-1) return true;
                for(int j=i;j<n;j++){
                    if(dp[i+1][j]==1){
                        dp[0][j]=1;
                    }
                }
            }
        }
        if(dp[0][n-1]==1) return true;
        else return false;
    }
}
