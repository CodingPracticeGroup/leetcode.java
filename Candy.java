public class Solution {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n=ratings.length;
        int[] candys=new int[n];
        candys[0]=1;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1])
              candys[i]=candys[i-1]+1;
            else candys[i]=1;
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
              candys[i]=Math.max(candys[i],candys[i+1]+1);
        }
        int result=0;
        for(int i=0;i<n;i++){
            result+=candys[i];
        }
        return result;
    }
}
