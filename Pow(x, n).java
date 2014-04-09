public class Solution {
    public double pow(double x, int n) {
        if (n > 0) {
			return powP(x, n);
		} else if(n < 0) {
		    if(n==Integer.MIN_VALUE){
		        return 1 / (powP(x, -n-1) * x);
		    }
			return 1 / powP(x, -n);
		}else{
		    return 1.0;
		}
    }
    
    public double powP(double x, int n){
        int bitmask = 0x01<<30;
        //find the most significant bit
        while((n&bitmask)==0){
            bitmask=bitmask>>1;
        }
        bitmask=bitmask>>1;
        double result=x;
        while(bitmask!=0){
            //n=2^2+2^1+...
            result*=result;
            if((bitmask&n)!=0){
                result*=x;
            }
            bitmask=bitmask>>1;
        }
        return result;
    }
}
