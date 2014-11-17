public class Solution {
    public int minCut(String s) {
        if(null==s||s.length()==0) return 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int i=0;i<n;i++){
            //odd
            int l=i-1;
            int r=i+1;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                dp[l--][r++]=true;
            }
            //even
             l=i-1;
             r=i;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                dp[l--][r++]=true;
            }
        }
        int [] cuts = new int[n+1];
        cuts[n]=0;
        for(int i=n-1;i>=0;i--){
            cuts[i]=n-i;
            for(int j=i;j<n;j++){
                if(dp[i][j]){
                    cuts[i]=Math.min(cuts[i],1+cuts[j+1]);
                }
            }
        }
        return cuts[0]-1;
    }
}
