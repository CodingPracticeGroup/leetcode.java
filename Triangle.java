public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n=triangle.size();
        if(0==n) return 0;
        int[] dp = new int[n];
        dp[0]=triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            for(int j=i;j>=0;j--){
                dp[j]=triangle.get(i).get(j)+
                Math.min((i!=j?dp[j]:Integer.MAX_VALUE),
                (j>0?dp[j-1]:Integer.MAX_VALUE));
            }
        }
        Arrays.sort(dp);
        return dp[0];
    }
}