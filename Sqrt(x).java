public class Solution {
    public int sqrt(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(x<=0) return 0;
        if(x==1) return 1;
        int h=x/2+1;
        int l=0;
        int m=0;
        while(l<h){
            m=(l+h)/2;
            //int temp=m*m;
            int a=x/m;
            if(a==m) return a;
            if(m>a){
                h=m;
            }else{
                l=m+1;
            }
        }
        return h-1;
    }
}