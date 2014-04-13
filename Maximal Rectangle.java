public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(null==matrix) return 0;
        int m=matrix.length;
        if(0==m) return 0;
        int n=matrix[0].length;
        
        //straight forward solution: dp 0-j consecutive 0's
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=matrix[i][j]-'0';
                if(1==dp[i][j]&&j>0){
                    dp[i][j]=dp[i][j-1]+1;
                }
            }
        }
        int result=0; 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]!=0){
                    //expand down
                    int height=0;
                    int width=dp[i][j];
                    for(int row=i;row<m;row++){
                        if(dp[row][j]>=width){
                            height++;
                            result=Math.max(result,height*width);
                        }else if(dp[row][j]>0){
                            width=dp[row][j];
                            height++;
                            result=Math.max(result,height*width);
                        }else{
                            break;
                        }
                    }
                    
                }
            }
        }
        
        return result;
    }
}
